package com.knight.estoque.services.autoresservice.v1;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.knight.estoque.domain.v1.Autor;

@WebService(endpointInterface = "com.knight.estoque.services.autoresservice.v1.AutoresServiceCallback", portName = "AutoresServiceCallbackSOAP", serviceName = "AutoresServiceCallback", targetNamespace = "http://knight.com/estoque/services/AutoresService/v1", wsdlLocation = "WEB-INF/contracts/AutoresServiceCallback.wsdl")
public class AutoresServiceCallbackImpl implements AutoresServiceCallback {

	@Override
	@WebMethod
	@Oneway
	public void solicitarRelacaoDeAutoresCallback(
			@WebParam(name = "solicitarRelacaoDeAutoresResponse", targetNamespace = "http://knight.com/estoque/services/AutoresService/v1", partName = "parameters") SolicitarRelacaoDeAutoresResponse parameters) {
		List<Autor> autores = parameters.getAutor();

		System.out.println("Callback imprimindo:");
		for (Autor autor : autores) {
			System.out.println("\t" + autor.getNome());
		}

	}

}
