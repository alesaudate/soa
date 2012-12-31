package com.knight.estoque.services.autoresservice.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.knight.estoque.domain.v1.Autor;

@WebService(endpointInterface = "com.knight.estoque.services.autoresservice.v1.AutoresService", portName = "AutoresServiceSOAP", serviceName = "AutoresService", targetNamespace = "http://knight.com/estoque/services/AutoresService/v1", wsdlLocation = "AutoresService.wsdl")
public class AutoresServiceImpl implements AutoresService {

	@Override
	@WebMethod(action = "AutoresService/ListarAutores")
	@WebResult(name = "autor", targetNamespace = "")
	@RequestWrapper(localName = "listarAutores", targetNamespace = "http://knight.com/estoque/services/AutoresService/v1", className = "com.knight.estoque.services.autoresservice.v1.ListarAutores")
	@ResponseWrapper(localName = "listarAutoresResponse", targetNamespace = "http://knight.com/estoque/services/AutoresService/v1", className = "com.knight.estoque.services.autoresservice.v1.ListarAutoresResponse")
	public List<Autor> listarAutores() {
		Autor alexandre = new Autor();
		alexandre.setNome("Alexandre");
		return new ArrayList<>(Arrays.asList(alexandre));
	}
	
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9090/autoresService", new AutoresServiceImpl());
	}

}
