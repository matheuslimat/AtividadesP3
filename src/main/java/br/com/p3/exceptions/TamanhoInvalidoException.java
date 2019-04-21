package br.com.p3.exceptions;

public class TamanhoInvalidoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public TamanhoInvalidoException(String mensagem){
		super(mensagem);
	}
}
