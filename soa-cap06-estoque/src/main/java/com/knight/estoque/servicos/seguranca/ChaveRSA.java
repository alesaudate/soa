package com.knight.estoque.servicos.seguranca;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RSA")
@XmlAccessorType(XmlAccessType.FIELD)
public class ChaveRSA {

	private BigInteger modulus;

	private BigInteger publicExponent;

	public static ChaveRSA carregar() throws IOException,
			ClassNotFoundException {

		try (InputStream inputStream = ChaveRSA.class
				.getResourceAsStream("/public.key")) {
			ObjectInputStream ois = new ObjectInputStream(inputStream);
			RSAPublicKey rsaPublicKey = (RSAPublicKey) ois.readObject();
			ChaveRSA chaveRSA = new ChaveRSA();
			chaveRSA.modulus = rsaPublicKey.getModulus();
			chaveRSA.publicExponent = rsaPublicKey.getPublicExponent();
			return chaveRSA;
		}
	}

}
