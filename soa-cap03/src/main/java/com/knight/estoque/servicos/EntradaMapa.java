package com.knight.estoque.servicos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import com.knight.estoque.modelos.TipoPreco;

@XmlAccessorType(XmlAccessType.FIELD)
public class EntradaMapa {

   @XmlAttribute
   private TipoPreco tipoPreco;

   private Double preco;

   public EntradaMapa(TipoPreco tipoPreco, Double preco) {
      super();
      this.tipoPreco = tipoPreco;
      this.preco = preco;
   }

   public EntradaMapa() {

   }

   public TipoPreco getTipoPreco() {
      return tipoPreco;
   }

   public void setTipoPreco(TipoPreco tipoPreco) {
      this.tipoPreco = tipoPreco;
   }

   public Double getPreco() {
      return preco;
   }

   public void setPreco(Double preco) {
      this.preco = preco;
   }

}
