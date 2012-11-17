package com.knight.estoque.servicos;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.ws.security.WSSecurityException;
import org.apache.ws.security.message.WSSecHeader;
import org.apache.ws.security.message.WSSecTimestamp;
import org.apache.ws.security.message.WSSecUsernameToken;

public class WSSecurityHandler implements SOAPHandler<SOAPMessageContext> {

	private String username;
	private String password;

	private boolean encoded;

	public WSSecurityHandler(String username, String password) {
		this(username, password, false);
	}

	public WSSecurityHandler(String username, String password, boolean encoded) {
		this.username = username;
		this.password = password;
		this.encoded = encoded;
	}

	@Override
	public void close(MessageContext context) {
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return true;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		Boolean outbound = (Boolean) context
				.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if (outbound) {
			try {
				SOAPMessage message = context.getMessage();
				WSSecHeader header = new WSSecHeader();
				header.insertSecurityHeader(message.getSOAPBody()
						.getOwnerDocument());

				WSSecUsernameToken usernameToken = new WSSecUsernameToken();
				usernameToken.setUserInfo(username, password);
				usernameToken.setPasswordsAreEncoded(encoded);

				usernameToken.prepare(message.getSOAPBody().getOwnerDocument());
				usernameToken.appendToHeader(header);

				WSSecTimestamp timestamp = new WSSecTimestamp();
				timestamp.build(message.getSOAPBody().getOwnerDocument(),
						header);
			} catch (WSSecurityException | SOAPException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

}
