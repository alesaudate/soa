package com.knight.estoque.modelos;

import java.util.List;

public class EBook extends Livro {

	private FormatoArquivo formato = FormatoArquivo.PDF;

	public EBook() {
		super();
	}

	public EBook(Integer anoDePublicacao, List<Autor> autores, String editora,
			String nome, String resumo) {
		super(anoDePublicacao, autores, editora, nome, resumo);
	}

	public FormatoArquivo getFormato() {
		return formato;
	}

	public void setFormato(FormatoArquivo formato) {
		this.formato = formato;
	}

}
