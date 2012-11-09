package com.knight.estoque.servicos.seguranca;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.security.Key;
import java.util.Date;

import javax.crypto.Cipher;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.codec.binary.Base64;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
class Usuario {

	private String nome;
	private String login;
	private String senha;
	private Date dataAtualizacao;

	private static Cipher cipher;

	static {
		try {
			InputStream keyStream = Thread.currentThread()
					.getContextClassLoader().getResourceAsStream("private.key");
			ObjectInputStream ois = new ObjectInputStream(keyStream);
			Key decodeKey = (Key) ois.readObject();
			ois.close();
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, decodeKey);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public Usuario() {
	}

	public Usuario(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public String getSenhaDecodificada() {
		try {
			return new String(cipher.doFinal(Base64.decodeBase64(senha
					.getBytes())));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

}
