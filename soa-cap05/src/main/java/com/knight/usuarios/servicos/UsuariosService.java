package com.knight.usuarios.servicos;

import java.net.URI;
import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.knight.usuarios.modelos.Usuario;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
@Stateless
public class UsuariosService {

   @PersistenceContext
   private EntityManager em;

   @GET
   public Collection<Usuario> list() {
      return em.createQuery("select u from Usuario u", Usuario.class)
            .getResultList();
   }

   @GET
   @Path("/{id}")
   public Response find(@PathParam("id") Long id) {
      Usuario usuario = em.find(Usuario.class, id);
      if (usuario != null)
         return Response.ok(usuario).build();
      return Response.status(Status.NOT_FOUND).build();
   }

   @POST
   public Response create(@Context UriInfo uriInfo, Usuario usuario) {
      em.persist(usuario);
      URI location = uriInfo.getAbsolutePathBuilder().path("/{id}")
            .build(usuario.getId());
      return Response.created(location).build();
   }

   @PUT
   public Response update(Usuario usuario) {
      usuario = em.merge(usuario);
      return Response.ok().build();
   }

   @PUT
   @Path("/{id}")
   public Response update(@PathParam("id") Long id, Usuario usuario) {
      usuario.setId(id);
      return update(usuario);
   }

   @DELETE
   public Response delete(Usuario usuario) {
      em.remove(usuario);
      return Response.ok().build();
   }

   @DELETE
   @Path("/{id}")
   public Response delete(@PathParam("id") Long id) {
      Usuario usuario = new Usuario();
      usuario.setId(id);
      return delete(usuario);
   }
}
