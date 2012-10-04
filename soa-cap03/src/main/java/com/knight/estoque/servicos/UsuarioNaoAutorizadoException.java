package com.knight.estoque.servicos;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.ws.WebFault;

@WebFault(
      targetNamespace = "http://servicos.estoque.knight.com/excecoes/",
      name = "UsuarioNaoAutorizado")
public class UsuarioNaoAutorizadoException extends Exception {

   private static final long serialVersionUID = 1L;

   public UsuarioNaoAutorizadoException() {
   }

   public UsuarioNaoAutorizadoException(String message) {
      super(message);
   }

   public UsuarioNaoAutorizadoException(Throwable cause) {
      super(cause);
   }

   public UsuarioNaoAutorizadoException(String message, Throwable cause) {
      super(message, cause);
   }

   public UsuarioNaoAutorizadoException(String message, Throwable cause,
         boolean enableSuppression, boolean writableStackTrace) {
      super(message, cause, enableSuppression, writableStackTrace);
   }

   public UsuarioFaultInfo getFaultInfo() {
      return new UsuarioFaultInfo(getMessage());
   }

   @XmlAccessorType(XmlAccessType.FIELD)
   public static class UsuarioFaultInfo {

      @XmlAttribute
      private String mensagem;

      private Date data;

      public UsuarioFaultInfo(String mensagem) {
         this.mensagem = mensagem;
         this.data = new Date();

      }

      public UsuarioFaultInfo() {
      }

      public Date getData() {
         return data;
      }

   }

}
