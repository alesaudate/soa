package com.knight.estoque.servicos;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Mapa {

   @XmlElement(
         name = "entrada")
   private List<EntradaMapa> entradas = new ArrayList<>();

   public List<EntradaMapa> getEntradas() {
      return entradas;
   }

   public void setEntradas(List<EntradaMapa> entradas) {
      this.entradas = entradas;
   }

}
