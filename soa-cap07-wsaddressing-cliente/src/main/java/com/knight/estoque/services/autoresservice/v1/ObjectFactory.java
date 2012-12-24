
package com.knight.estoque.services.autoresservice.v1;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.knight.estoque.services.autoresservice.v1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.knight.estoque.services.autoresservice.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SolicitarRelacaoDeAutores }
     * 
     */
    public SolicitarRelacaoDeAutores createSolicitarRelacaoDeAutores() {
        return new SolicitarRelacaoDeAutores();
    }

    /**
     * Create an instance of {@link ListarAutores }
     * 
     */
    public ListarAutores createListarAutores() {
        return new ListarAutores();
    }

    /**
     * Create an instance of {@link ListarAutoresResponse }
     * 
     */
    public ListarAutoresResponse createListarAutoresResponse() {
        return new ListarAutoresResponse();
    }

    /**
     * Create an instance of {@link SolicitarRelacaoDeAutoresResponse }
     * 
     */
    public SolicitarRelacaoDeAutoresResponse createSolicitarRelacaoDeAutoresResponse() {
        return new SolicitarRelacaoDeAutoresResponse();
    }

}
