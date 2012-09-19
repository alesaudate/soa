
package com.knight.estoque.servicos;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for listarLivrosPaginacaoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listarLivrosPaginacaoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="livro" type="{http://servicos.estoque.knight.com/}livro" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listarLivrosPaginacaoResponse", propOrder = {
    "livro"
})
public class ListarLivrosPaginacaoResponse {

    protected List<Livro> livro;

    /**
     * Gets the value of the livro property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the livro property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLivro().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Livro }
     * 
     * 
     */
    public List<Livro> getLivro() {
        if (livro == null) {
            livro = new ArrayList<Livro>();
        }
        return this.livro;
    }

}
