package com.knight.estoque.modelos;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class Livro {
	
	private Integer anoDePublicacao;
	
	@XmlElementWrapper(name="autores")
	@XmlElement(name="autor")
	private List<String> autores;
	private String editora;
	private String nome;
	private String resumo;
	
	public Livro() {}
	
	public Livro(Integer anoDePublicacao, List<String> autores, String editora,
			String nome, String resumo) {
		super();
		this.anoDePublicacao = anoDePublicacao;
		this.autores = autores;
		this.editora = editora;
		this.nome = nome;
		this.resumo = resumo;
	}
	public Integer getAnoDePublicacao() {
		return anoDePublicacao;
	}
	public void setAnoDePublicacao(Integer anoDePublicacao) {
		this.anoDePublicacao = anoDePublicacao;
	}
	public List<String> getAutores() {
		return autores;
	}
	public void setAutores(List<String> autores) {
		this.autores = autores;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	
	

}
