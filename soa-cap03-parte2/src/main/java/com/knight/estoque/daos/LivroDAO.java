package com.knight.estoque.daos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.knight.estoque.servicos.Livro;

public class LivroDAO {

	public List<Livro> listarLivros() {
		List<Livro> livros = new ArrayList<>();
		livros.add(new Livro(2012, new Livro.Autores(new ArrayList<>(Arrays.asList("Paulo Silveira", "Adriano Almeida"))), "Casa do Código", "Guia do Programador", "Vá do \"nunca programei\" ..."));
		livros.add(new Livro(2012, new Livro.Autores(new ArrayList<>(Arrays.asList("Vinícius Baggio Fuentes"))), "Casa do Código", "Ruby on Rails", "Crie rapidamente aplicações web"));
		return livros;
	}
	
	
	public List<Livro> listarLivros(Integer numeroDaPagina, Integer tamanhoDaPagina) {
		List<Livro> livros = listarLivros();
		
		int indiceInicial = numeroDaPagina * tamanhoDaPagina;
		int indiceFinal = indiceInicial + tamanhoDaPagina;
		
		indiceFinal = indiceFinal > livros.size() ? livros.size() : indiceFinal; 
		indiceInicial = indiceInicial > indiceFinal ? indiceFinal : indiceInicial;
		
		return livros.subList(indiceInicial, indiceFinal);
		
		
	}


}
