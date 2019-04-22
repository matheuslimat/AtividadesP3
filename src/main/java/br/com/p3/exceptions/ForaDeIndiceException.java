package br.com.p3.exceptions;

public class ForaDeIndiceException extends Exception{
	private static final long serialVersionUID = 1L;

	public ForaDeIndiceException(String mensagem){
		super(mensagem);
	}
}
