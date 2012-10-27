package com.knight.usuarios.modelos;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.knight.usuarios.modelos.rest.Link;
import com.knight.usuarios.modelos.rest.RESTEntity;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity
public class Usuario extends EntidadeModelo implements RESTEntity {

   @Id
   @GeneratedValue(
         strategy = GenerationType.IDENTITY)
   private Long id;

   private String nome;
   private String login;
   private String senha;

   @OneToOne(
         cascade = { CascadeType.ALL }, orphanRemoval = true)
   @XmlTransient
   private Imagem imagem;

   @XmlElement(
         name = "link")
   @Transient
   private Collection<Link> links;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getNome() {
      if (nome != null)
         return nome;
      return "";
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getLogin() {
      if (login != null)
         return login;
      return "";
   }

   public void setLogin(String login) {
      this.login = login;
   }

   public String getSenha() {
      if (senha != null)
         return senha;
      return "";
   }

   public void setSenha(String senha) {
      this.senha = senha;
   }

   public Imagem getImagem() {
      return imagem;
   }

   public void setImagem(Imagem imagem) {
      this.imagem = imagem;
   }

   @Override
   public void adicionarLink(Link link) {
      if (links == null) {
         links = new ArrayList<>();
      }
      links.add(link);
   }

}
