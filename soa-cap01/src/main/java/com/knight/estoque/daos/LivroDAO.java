package com.knight.estoque.daos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.knight.estoque.modelos.Livro;

public class LivroDAO {

	public List<Livro> listarLivros() {
		List<Livro> livros = new ArrayList<Livro>();
		livros.add(new Livro(2012, new ArrayList<String>(Arrays.asList("Paulo Silveira", "Adriano Almeida")), "Casa do Código", "Guia do Programador", "Vá do \"nunca programei\" ..."));
		livros.add(new Livro(2012, new ArrayList<String>(Arrays.asList("Vinícius Baggio Fuentes")), "Casa do Código", "Ruby on Rails", "Crie rapidamente aplicações web"));
		return livros;
	}

}
