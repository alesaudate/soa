package com.knight.estoque.servicos;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;

import com.knight.estoque.modelos.Livro;
import com.knight.estoque.modelos.Usuario;

@WebService
@Stateless
public class LivrosService {

   @PersistenceContext
   private EntityManager em;

   @WebResult(
         name = "livro")
   public List<Livro> listarLivros() {
      return em.createQuery(
            "select distinct l from Livro l left join FETCH l.autores",
            Livro.class).getResultList();
   }

   @WebResult(
         name = "livro")
   public List<Livro> listarLivrosPaginacao(int numeroDaPagina,
         int tamanhoDaPagina) {

      TypedQuery<Livro> query = em.createQuery(
            "select distinct l from Livro l left join FETCH l.autores",
            Livro.class);
      query.setFirstResult(numeroDaPagina * tamanhoDaPagina);
      query.setMaxResults(tamanhoDaPagina);
      return query.getResultList();
   }

   public void criarLivro(@WebParam(
         name = "livro") Livro livro, @WebParam(
         name = "usuario", header = true) Usuario usuario)
         throws UsuarioNaoAutorizadoException, SOAPException {
      if (usuario.getLogin().equals("soa") && usuario.getSenha().equals("soa")) {
         em.persist(livro);
      } else if (usuario.getNome().equals("faultCode")) {
         SOAPFault soapFault = SOAPFactory.newInstance().createFault(
               "Usuário não autorizado",
               new QName(SOAPConstants.URI_NS_SOAP_1_1_ENVELOPE,
                     "Client.autorizacao"));
         soapFault
               .setFaultActor("http://servicos.estoque.knight.com/LivrosService");
         throw new SOAPFaultException(soapFault);
      } else {
         throw new UsuarioNaoAutorizadoException("Usuário não autorizado");
      }
   }

}
