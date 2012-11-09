package com.knight.usuarios.modelos.rest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(
      namespace = "http://knight.com/links")
@XmlAccessorType(XmlAccessType.FIELD)
public class Link {

   @XmlAttribute
   private String href;

   @XmlAttribute
   private String rel;

   @XmlAttribute
   private String type;

   public Link(String href, String rel) {
      this.href = href;
      this.rel = rel;
   }

   public Link(String href, String rel, String type) {
      this(href, rel);
      this.type = type;
   }

   public Link() {
   }

   public String getHref() {
      return href;
   }

   public void setHref(String href) {
      this.href = href;
   }

   public String getRel() {
      return rel;
   }

   public void setRel(String rel) {
      this.rel = rel;
   }

}
