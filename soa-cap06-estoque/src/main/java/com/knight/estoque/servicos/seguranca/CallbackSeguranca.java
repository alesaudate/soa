package com.knight.estoque.servicos.seguranca;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.apache.ws.security.WSPasswordCallback;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.util.Base64;
import org.jboss.resteasy.util.DateUtil;

public class CallbackSeguranca implements CallbackHandler {

	private static String USUARIO = "admin";

	private static String SENHA = "admin";

	private static ChaveRSA chaveRSA;

	static {
		try {
			chaveRSA = ChaveRSA.carregar();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static String ENDERECO_SERVICO_USUARIOS = "https://localhost:8443/soa-cap06-usuarios-0.0.1-SNAPSHOT/services/usuarios/{login}";

	private static Map<String, Usuario> cache = new ConcurrentHashMap<>();

	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) {
			if (callbacks[i] instanceof WSPasswordCallback) {
				WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];

				Usuario usuario = encontreUsuario(pc.getIdentifier());
				if (usuario == null)
					return;
				pc.setPassword(usuario.getSenhaDecodificada());
			}
		}

	}

	private Usuario encontreUsuario(String login) throws IOException {
		Usuario usuario = null;
		try {

			ClientRequest request = new ClientRequest(ENDERECO_SERVICO_USUARIOS)
					.pathParameters(login).header("Authorization", getAuth())
					.body(MediaType.APPLICATION_XML, chaveRSA)
					.accept(MediaType.APPLICATION_XML);

			if (cache.containsKey(login)) {
				usuario = cache.get(login);
				request.header("If-Modified-Since",
						DateUtil.formatDate(usuario.getDataAtualizacao()));
			}

			@SuppressWarnings("unchecked")
			ClientResponse<Usuario> response = request.post();
			if (response.getStatus() == Status.NOT_MODIFIED.getStatusCode()) {
				return usuario;
			}

			if (response.getStatus() == Status.OK.getStatusCode()) {
				usuario = response.getEntity(Usuario.class);

				Date date = DateUtil.parseDate(response.getHeaders().getFirst(
						"Date"));
				usuario.setDataAtualizacao(date);
				cache.put(login, usuario);
				return usuario;
			}

			if (response.getStatus() == Status.NOT_FOUND.getStatusCode()) {
				return null;
			}

			throw new Exception("Usuário não localizado");
		} catch (Exception e) {
			throw new IOException(
					"Não foi possível recuperar as informações do usuário");
		}

	}

	private String getAuth() {
		return "Basic "
				+ Base64.encodeBytes((USUARIO + ":" + SENHA).getBytes());
	}

}
