package com.knight.estoque.servicos;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.knight.estoque.modelos.Autor;

@WebService
@Stateless
public class AutoresService {

   @PersistenceContext
   private EntityManager em;

   public List<Autor> listarAutores() {
      return em.createQuery("select a from Autor a", Autor.class)
            .getResultList();
   }

}
