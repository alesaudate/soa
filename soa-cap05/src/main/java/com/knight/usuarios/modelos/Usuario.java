package com.knight.usuarios.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity
public class Usuario {

   @Id
   @GeneratedValue(
         strategy = GenerationType.IDENTITY)
   private Long id;

   private String nome;
   private String login;
   private String senha;

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

}
