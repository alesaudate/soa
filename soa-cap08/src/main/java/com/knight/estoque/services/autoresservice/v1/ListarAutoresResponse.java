
package com.knight.estoque.services.autoresservice.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.knight.estoque.domain.v1.Autor;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="autor" type="{http://knight.com/estoque/domain/v1}autor" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "autor"
})
@XmlRootElement(name = "listarAutoresResponse")
public class ListarAutoresResponse {

    @XmlElement(required = true)
    protected List<Autor> autor;

    /**
     * Gets the value of the autor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the autor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAutor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Autor }
     * 
     * 
     */
    public List<Autor> getAutor() {
        if (autor == null) {
            autor = new ArrayList<Autor>();
        }
        return this.autor;
    }

}
