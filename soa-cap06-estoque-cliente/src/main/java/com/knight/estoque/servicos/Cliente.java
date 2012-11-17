package com.knight.estoque.servicos;

import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

public class Cliente {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		AutoresService service = new AutoresServiceService()
				.getAutoresServicePort();

		List<Handler> handlerChain = ((BindingProvider) service).getBinding()
				.getHandlerChain();

		handlerChain.add(new WSSecurityHandler("alexandre", "alexandre"));

		((BindingProvider) service).getBinding().setHandlerChain(handlerChain);
		List<Autor> autores = service.listarAutores();

		for (Autor autor : autores) {
			System.out.println(autor.getNome());
		}

		main(args);

	}

}
