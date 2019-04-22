package br.com.p3.arraylist;

import java.util.Arrays;

import org.apache.log4j.Logger;

import br.com.p3.exceptions.ForaDeIndiceException;
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
		if(isEstourou()) {
			this.objetos = duplicaTamanho(objetos);
		}
		this.objetos[posicao] = objeto;
		posicao++;
	}
	
	/**
	 * Retorna elemento pelo indice
	 * @param index representa a posição do elemento
	 */
	public Object get(int index){
		if(index > objetos.length || index < 0) {
			try {
				throw new ForaDeIndiceException("Indice não encontrado.");
			} catch (ForaDeIndiceException e) {
				System.out.println(e.getMessage());
			}
		}
		return objetos[index];
	}
	
	/**
	 * Procura pela primeira ocorrencia do objeto no arrai e retorna o indice dele
	 * @param objeto 
	 * @return retorna o indice do objeto no arrai se ele não for encontrado retorna -1
	 */
	public int indexOf(Object objeto) {
		int contIndice = 0;
		for (Object object : objetos) {
			if(objeto.equals(object)) {
				return contIndice;
			}
			contIndice++;
		}
		return -1;
	}
	
	/**
	 * Procura pelo ultimo indice do objeto passado
	 * @param objeto
	 * @return Retorna o ultimo indice da ocorrencia do objeto, se não tiver ocorrencia retorna -1
	 */
	public int lastIndexOf(Object objeto) {
		int contIndice = 0;
		int ultimaOcorrencia = 0;
		Boolean temOcorrencia = false;
		for (Object object : objetos) {
			if(objeto.equals(object)) {
				ultimaOcorrencia = contIndice;
				temOcorrencia = true;
			}
			contIndice++;
		}
		return temOcorrencia ? ultimaOcorrencia : -1;
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

	@Override
	public String toString() {
		return "ArraiList [objetos=" + Arrays.toString(objetos) + "]";
	}
	
	
}
