package com.knight.estoque.servicos;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.knight.estoque.daos.LivroDAO;


@WebService(name = "ListagemLivros", 
	serviceName="ListagemLivrosService",
	targetNamespace = "http://servicos.estoque.knight.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public class ListagemLivrosService implements ListagemLivros {

	@Override
	@WebMethod
	@WebResult(name = "livro", targetNamespace = "")
	@RequestWrapper(localName = "listarLivrosPaginacao", targetNamespace = "http://servicos.estoque.knight.com/", className = "com.knight.estoque.servicos.ListarLivrosPaginacao")
	@ResponseWrapper(localName = "listarLivrosPaginacaoResponse", targetNamespace = "http://servicos.estoque.knight.com/", className = "com.knight.estoque.servicos.ListarLivrosPaginacaoResponse")
	@Action(input = "http://servicos.estoque.knight.com/ListagemLivros/listarLivrosPaginacaoRequest", output = "http://servicos.estoque.knight.com/ListagemLivros/listarLivrosPaginacaoResponse")
	public List<Livro> listarLivrosPaginacao(
			@WebParam(name = "arg0", targetNamespace = "") int arg0,
			@WebParam(name = "arg1", targetNamespace = "") int arg1) {
		return getLivroDAO().listarLivros(arg0, arg1);
	}

	@Override
	@WebMethod
	@WebResult(name = "livro", targetNamespace = "")
	@RequestWrapper(localName = "listarLivros", targetNamespace = "http://servicos.estoque.knight.com/", className = "com.knight.estoque.servicos.ListarLivros")
	@ResponseWrapper(localName = "listarLivrosResponse", targetNamespace = "http://servicos.estoque.knight.com/", className = "com.knight.estoque.servicos.ListarLivrosResponse")
	@Action(input = "http://servicos.estoque.knight.com/ListagemLivros/listarLivrosRequest", output = "http://servicos.estoque.knight.com/ListagemLivros/listarLivrosResponse")
	public List<Livro> listarLivros() {
		return getLivroDAO().listarLivros();
	}

	@Override
	@WebMethod
	@RequestWrapper(localName = "criarLivro", targetNamespace = "http://servicos.estoque.knight.com/", className = "com.knight.estoque.servicos.CriarLivro")
	@ResponseWrapper(localName = "criarLivroResponse", targetNamespace = "http://servicos.estoque.knight.com/", className = "com.knight.estoque.servicos.CriarLivroResponse")
	@Action(input = "http://servicos.estoque.knight.com/ListagemLivros/criarLivroRequest", output = "http://servicos.estoque.knight.com/ListagemLivros/criarLivroResponse")
	public void criarLivro(
			@WebParam(name = "arg0", targetNamespace = "") Livro arg0,
			@WebParam(name = "arg1", targetNamespace = "") Usuario arg1) {
	
	}

	private LivroDAO getLivroDAO() {
		return new LivroDAO();
	}
}
