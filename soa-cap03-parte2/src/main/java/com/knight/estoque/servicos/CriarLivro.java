
package com.knight.estoque.servicos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for criarLivro complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="criarLivro">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://servicos.estoque.knight.com/}livro" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://servicos.estoque.knight.com/}usuario" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criarLivro", propOrder = {
    "arg0",
    "arg1"
})
public class CriarLivro {

    protected Livro arg0;
    protected Usuario arg1;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link Livro }
     *     
     */
    public Livro getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Livro }
     *     
     */
    public void setArg0(Livro value) {
        this.arg0 = value;
    }

    /**
     * Gets the value of the arg1 property.
     * 
     * @return
     *     possible object is
     *     {@link Usuario }
     *     
     */
    public Usuario getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Usuario }
     *     
     */
    public void setArg1(Usuario value) {
        this.arg1 = value;
    }

}
