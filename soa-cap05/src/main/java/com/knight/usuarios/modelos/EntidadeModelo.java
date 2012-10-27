package com.knight.usuarios.modelos;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

@MappedSuperclass
public abstract class EntidadeModelo {

   @Temporal(TemporalType.TIMESTAMP)
   private Date dataAtualizacao;

   @XmlTransient
   public Date getDataAtualizacao() {
      return dataAtualizacao;
   }

   public void setDataAtualizacao(Date dataAtualizacao) {
      this.dataAtualizacao = dataAtualizacao;
   }

   @PreUpdate
   @PrePersist
   protected void ajustarDataAtualizacao() {
      this.dataAtualizacao = new Date();
   }

}
