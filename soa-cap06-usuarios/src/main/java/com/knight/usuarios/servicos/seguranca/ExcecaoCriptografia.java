package com.knight.usuarios.servicos.seguranca;

public class ExcecaoCriptografia extends Exception {

	private static final long serialVersionUID = 1L;

	public ExcecaoCriptografia() {
		super();

	}

	public ExcecaoCriptografia(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public ExcecaoCriptografia(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcecaoCriptografia(String message) {
		super(message);
	}

	public ExcecaoCriptografia(Throwable cause) {
		super(cause);
	}

}
