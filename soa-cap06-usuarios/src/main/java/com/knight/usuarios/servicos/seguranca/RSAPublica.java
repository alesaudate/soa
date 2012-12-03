package com.knight.usuarios.servicos.seguranca;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.codec.binary.Base64;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "RSA")
public class RSAPublica {

	private BigInteger modulus;

	private BigInteger publicExponent;

	public String encripta(byte[] bytes) throws ExcecaoCriptografia {
		try {
			PublicKey publicKey = criaChave();
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			return Base64.encodeBase64String(cipher.doFinal(bytes));
		} catch (Exception e) {
			throw new ExcecaoCriptografia(e);
		}
	}

	protected PublicKey criaChave() throws InvalidKeySpecException,
			NoSuchAlgorithmException {
		RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(modulus,
				publicExponent);
		return KeyFactory.getInstance("RSA").generatePublic(publicKeySpec);
	}
}
