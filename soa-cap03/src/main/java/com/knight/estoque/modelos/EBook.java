package com.knight.estoque.modelos;

import java.util.List;

public class EBook extends Livro {

	private String formato = "PDF";

	public EBook() {
		super();
	}

	public EBook(Integer anoDePublicacao, List<Autor> autores, String editora,
			String nome, String resumo) {
		super(anoDePublicacao, autores, editora, nome, resumo);
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

}
