package com.knight.usuarios.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Imagem extends EntidadeModelo {

   @Id
   @GeneratedValue(
         strategy = GenerationType.IDENTITY)
   private Long id;

   @Lob
   private byte[] dados;
   private String tipo;
   private String descricao;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public byte[] getDados() {
      return dados;
   }

   public void setDados(byte[] dados) {
      this.dados = dados;
   }

   public String getTipo() {
      return tipo;
   }

   public void setTipo(String tipo) {
      this.tipo = tipo;
   }

   public String getDescricao() {
      return descricao;
   }

   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }

}
