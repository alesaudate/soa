package com.knight.usuarios.servicos;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import com.knight.usuarios.modelos.Usuario;


@WebService
public class UsuariosService {
	
	
	public void criarUsuario (Usuario usuario) {
		// lógica de criação de usuários
	}
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/usuarios", new UsuariosService());
		System.out.println("Serviço inicializado!");
	}

}
