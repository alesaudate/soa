package com.knight.estoque.servicos;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceContext;

import org.apache.ws.security.WSUsernameTokenPrincipal;
import org.jboss.ws.api.annotation.EndpointConfig;
import org.jboss.ws.api.annotation.WebContext;

import com.knight.estoque.modelos.Autor;

@WebService(portName = "AutoresServicePort", serviceName = "AutoresServiceService", targetNamespace = "http://servicos.estoque.knight.com/", wsdlLocation = "WEB-INF/wsdl/AutoresService.wsdl")
@EndpointConfig(configFile = "WEB-INF/jaxws-endpoint-config.xml", configName = "Endpoint WS-Security")
@WebContext(transportGuarantee = "CONFIDENTIAL", urlPattern = "AutoresService")
@Stateless
public class AutoresService {

	@Resource
	private WebServiceContext context;

	@PersistenceContext
	private EntityManager em;

	public List<Autor> listarAutores() {
		WSUsernameTokenPrincipal principal = (WSUsernameTokenPrincipal) context
				.getUserPrincipal();

		return em.createQuery("select a from Autor a", Autor.class)
				.getResultList();
	}

}
