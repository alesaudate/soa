package com.knight.usuarios.servicos;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import com.knight.usuarios.modelos.Usuario;


@WebService
public class UsuariosService {
	
	
	public void criarUsuario (Usuario usuario) {
		
	}
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8090/usuarios/usuarioService", new UsuariosService());
		System.out.println("Serviço inicializado!");
	}

}
