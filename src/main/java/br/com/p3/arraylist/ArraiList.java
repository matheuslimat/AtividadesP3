package br.com.p3.arraylist;

import java.util.Arrays;
import java.util.Iterator;

import br.com.p3.exceptions.TamanhoInvalidoException;
import br.com.p3.exceptions.ValorNuloException;

/**
 * Simula comportamento de um array
 * @author Matheus Lima Tavares da Costa
 */
public class ArraiList 
{
	private Object[] objetos;
	private int posicao = 0;
	private static final int TAMANHOPADRAO = 12;

	/**
	 * Cria um array de tamanho padrão
	 */
	public ArraiList() {
		this.objetos = new Object[TAMANHOPADRAO];
	}

	/**
	 * Construtor do arrai com tamanho passado
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
	 * Função adciona objeto ao arrai
	 * @param objeto Representa o objeto a ser adicionado na lista
	 * @throws ValorNuloException é chamado toda vez que o objeto passado for nulo
	 */
	public void add(Object objeto){
		verificaNulo(objeto);
		if(isEstourou()) {
			this.objetos = duplicaTamanho(objetos);
		}
		this.objetos[posicao] = objeto;
		posicao++;
	}

	public void add(int indice, Object objeto){
		verificaNulo(objeto);
		if(isEstourou()) {
			this.objetos = duplicaTamanho(objetos);
		}else {
			this.objetos = aumentaUm(objetos);
		}
		insereNoIndice(indice, objeto);
		posicao++;
	}

	private Object[] insereNoIndice(int indice, Object objeto) {
		Object[] temp = clone();
		temp[indice] = objeto;
		for (int i = indice; i < objetos.length; i++) {
			temp[indice + 1] = objetos[i];
		}
		return temp;
	}

	/**
	 * Retorna elemento pelo indice
	 * @param index representa a posição do elemento
	 */
	public Object get(int index){
		if(index >= posicao || index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return objetos[index];
	}

	/**
	 * Procura pela primeira ocorrencia do objeto no arrai e retorna o indice dele
	 * @param objeto 
	 * @return retorna o indice do objeto no arrai se ele não for encontrado retorna -1
	 */
	public int indexOf(Object objeto) {
		verificaNulo(objeto);
		int contIndice = -1;
		for (int i = 0; i < posicao; i++) {
			if(objeto.equals(objetos[i])) {
				contIndice = i;
			}
		}
		return contIndice;
	}

	/**
	 * Procura pelo ultimo indice do objeto passado
	 * @param objeto
	 * @return Retorna o ultimo indice da ocorrencia do objeto, se não tiver ocorrencia retorna -1
	 */
	public int lastIndexOf(Object objeto) {
		verificaNulo(objeto);
		int ultimaOcorrencia = -1;
		for (int i = 0; i < posicao; i++) {
			if(objeto.equals(objetos[i])) {
				ultimaOcorrencia = i;
			}
		}
		return ultimaOcorrencia;
	}

	@SuppressWarnings("unused")
	public void clear() {
		for (Object object : objetos) {
			object = null;
		}
		this.posicao = 0;
	}

	/**
	 * Remove objeto do arrai pelo indice
	 * @param indice
	 */
	public void remove(int indice) {
		if(indice > posicao) {
			throw new ArrayIndexOutOfBoundsException();
		}
		objetos[indice] = null;
		for (int i = indice; i < posicao; i++) {
			objetos[i] = objetos[i + 1];
		}
		posicao--;
	}

	/**
	 * Remove um objeto
	 * @param object
	 */
	public void remove(Object objeto) {
		verificaNulo(objeto);
		Boolean achou = false;
		for (int i = 0; i < posicao; i++) {
			if(objetos[i].equals(objeto)) {
				objetos[i] = null;
				achou = true;
				break;
			}else if(!achou) {
				throw new NullPointerException();
			}
		}
		posicao --;

	}

	/**
	 * Metodo retorna uma copia da lista atual
	 */
	public Object[] clone() {
		Object[] copia = new Object[objetos.length];
		for (int i = 0; i < objetos.length; i++) {
			copia[i] = this.objetos[i];
		}
		return copia;
	}

	/**
	 * Esse metódo retorna o tamanho da lista de objetos
	 * @return
	 */
	public int size() {
		return posicao;
	}

	/**
	 * Retorna se o array está vazio.
	 * @return
	 */
	public boolean isEmpty() {
		return posicao == 0;
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
	public void verificaNulo(Object objeto) {
		if(objeto == null) {
			throw new NullPointerException();
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

	/**
	 * Caso seja usado o add com indice
	 * @param objetos
	 * @return
	 */
	public Object[] aumentaUm(Object[] objetos) {
		Object[] temp = new Object[objetos.length + 1];
		for (int i = 0; i < objetos.length; i++) {
			temp[i] = objetos[i];
		}
		return temp;
	}

	/**
	 * Metódo para saber se um objeto se encontra no arrai
	 * @param objeto
	 * @return
	 */
	public Boolean isContain(Object objeto) {
		verificaNulo(objeto);
		Boolean contem = false;
		if(size() > 0) {
			for (int i = 0; i < posicao; i++) {
				if(objetos[i].equals(objeto)) {
					contem = true;
				}
			}
		}
		return contem;
	}

	@Override
	public String toString() {
		return "ArraiList [objetos=" + Arrays.toString(objetos) + "]";
	}


}
