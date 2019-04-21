package br.com.p3.arraylist;

import java.util.ArrayList;

import br.com.p3.exceptions.TamanhoInvalidoException;
import br.com.p3.exceptions.ValorNuloException;

/**
 * Simula comportamento de um array
 * @author Matheus Costa
 */
public class ArraiList 
{
	private Object[] objetos;
	private int posicao = 0;
	private static final int tamanhoPadrao = 12;
	
	ArrayList<String> teste = new ArrayList();
	/**
	 * Cria um array de tamanho padrão
	 */
	public ArraiList() {
		this.objetos = new Object[tamanhoPadrao];
	}

	/**
	 * 
	 * @param Especifica o tamanho do array
	 * @throws TamanhoInvalidoException é chamado toda vez que o tamanho passado for inválido
	 */
	public ArraiList(int tamanho){
		if (tamanho < 1){
			throw new TamanhoInvalidoException("Tamanho Inválido");
		}else{
			this.objetos = new Object[tamanho];
		}
	}
	
	/**
	 * 
	 * @param objeto Representa o objeto a ser adicionado na lista
	 * @throws ValorNuloException é chamado toda vez que o objeto passado for nulo
	 */
	public void add(Object objeto) throws ValorNuloException{
		verificaNulo(objeto);
		if(isEstourou()) {
			this.objetos = duplicaTamanho(objetos);
		}
		this.objetos[posicao] = objeto;
		posicao++;
	}
	
	/**
	 * 
	 * @return Retorna se o tamanho da lista é zero
	 */
	private Boolean isEstourou() {
		return this.objetos.length == posicao ? true : false;
	}

	/**
	 * Retorna uma exceçao caso o objeto seja nulo
	 * @param objeto Representa o objeto a ser verificado
	 * @throws ValorNuloException 
	 */
	public void verificaNulo(Object objeto) throws ValorNuloException {
		if(objeto == null) {
			throw new ValorNuloException("Objeto passado não pode ser nulo!");
		}
	}
	
	/**
	 * Caso o arrai não tenha mais espaço essa função duplica o tamanho
	 * @param objetos
	 * @return
	 */
	public Object[] duplicaTamanho(Object[] objetos) {
		int novoTamanho = objetos.length * 2;
		Object[] temp = new Object[novoTamanho];
		for (int i = 0; i < objetos.length; i++) {
			temp[i] = objetos[i];
		}
		return temp;
	}
	
}
