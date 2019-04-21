package br.com.p3.exceptions;

public class ValorNuloException extends Exception {
	private static final long serialVersionUID = 1L;

	public ValorNuloException(String mensagem){
		super(mensagem);
	}
}
