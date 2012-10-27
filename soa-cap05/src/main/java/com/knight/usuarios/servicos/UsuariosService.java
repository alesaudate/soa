package com.knight.usuarios.servicos;

import java.net.URI;
import java.util.Collection;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.knight.usuarios.modelos.Imagem;
import com.knight.usuarios.modelos.Usuario;
import com.knight.usuarios.modelos.Usuarios;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
@Stateless
public class UsuariosService {

   @PersistenceContext
   private EntityManager em;

   public static final String CAMPO_DESCRICAO_IMAGEM = "Descricao";

   @GET
   public Response listarUsuarios(@HeaderParam("If-Modified-Since") Date date) {
      Collection<Usuario> usuarios = em.createQuery("select u from Usuario u",
            Usuario.class).getResultList();

      boolean atualizado = false;

      if (date != null) {
         for (Usuario usuario : usuarios) {
            if (usuario.getDataAtualizacao().after(date)) {
               atualizado = true;
               break;
            }
         }
      } else {
         // Se a data não tiver sido passada, deve considerar os recursos
         // como 'mais atuais'
         atualizado = true;
      }

      if (atualizado) {
         return Response.ok(new Usuarios(usuarios)).build();
      } else {
         return Response.notModified().build();
      }

   }

   @GET
   @Path("/{id}")
   public Response find(@PathParam("id") Long id,
         @HeaderParam("If-Modified-Since") Date modifiedSince) {
      Usuario usuario = em.find(Usuario.class, id);

      if (usuario != null) {
         if (modifiedSince == null
               || (modifiedSince != null && usuario.getDataAtualizacao().after(
                     modifiedSince))) {
            return Response.ok(usuario).build();
         }

         return Response.notModified().build();
      }
      return Response.status(Status.NOT_FOUND).build();
   }

   @POST
   public Response create(@Context UriInfo uriInfo, Usuario usuario) {
      em.persist(usuario);

      // Constrói a URL onde o recurso estará disponível

      UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
      URI location = uriBuilder.path("/{id}").build(usuario.getId());

      return Response.created(location).build();
   }

   @PUT
   public Response update(Usuario usuario) {
      usuario = em.merge(usuario);
      return Response.noContent().build();
   }

   @PUT
   @Path("/{id}")
   public Response update(@PathParam("id") Long id, Usuario usuario) {
      usuario.setId(id);
      return update(usuario);
   }

   @DELETE
   public Response delete(Usuario usuario) {
      usuario = em.find(Usuario.class, usuario.getId());
      if (usuario == null) {
         return Response.status(Status.NOT_FOUND).build();
      }
      em.remove(usuario);
      return Response.noContent().build();
   }

   @DELETE
   @Path("/{id}")
   public Response delete(@PathParam("id") Long id) {
      Usuario usuario = new Usuario();
      usuario.setId(id);
      return delete(usuario);
   }

   @PUT
   @Path("/{id}")
   @Consumes("image/*")
   public Response adicionarImagem(
         @HeaderParam(CAMPO_DESCRICAO_IMAGEM) String descricao,
         @PathParam("id") Long idUsuario,
         @Context HttpServletRequest httpServletRequest, byte[] dadosImagem) {
      Usuario usuario = em.find(Usuario.class, idUsuario);
      if (usuario == null) {
         return Response.status(Status.NOT_FOUND).build();
      }
      Imagem imagem = new Imagem();
      imagem.setDados(dadosImagem);
      imagem.setDescricao(descricao);
      imagem.setTipo(httpServletRequest.getContentType());
      usuario.setImagem(imagem);
      em.merge(usuario);
      return Response.noContent().build();
   }

   @GET
   @Path("/{id}")
   @Produces("image/*")
   public Response recuperarImagem(@PathParam("id") Long id,
         @HeaderParam("If-Modified-Since") Date modifiedSince) {
      Usuario usuario = em.find(Usuario.class, id);
      if (usuario == null) {
         return Response.status(Status.NOT_FOUND).build();
      }
      Imagem imagem = usuario.getImagem();

      if (modifiedSince != null
            && imagem.getDataAtualizacao().before(modifiedSince)) {
         return Response.notModified().build();
      }

      return Response.ok(imagem.getDados(), imagem.getTipo())
            .header(CAMPO_DESCRICAO_IMAGEM, imagem.getDescricao()).build();
   }

}
