package com.knight.estoque.servicos;

import java.util.List;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Inicia a fábrica dos proxies
	      ListagemLivrosService listagemLivrosFactory = 
		new ListagemLivrosService();

	      //Obtém um proxy
	      ListagemLivros listagemLivros = 
		listagemLivrosFactory.getListagemLivrosPort();

	      //Executa o método remoto
	      List<Livro> livros = listagemLivros.listarLivros();
	      for (Livro livro : livros) {
	         System.out.println("Nome: " + livro.getNome());
	      }

	}

}
