package br.com.p3.arraylist;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Simula comportamento de um array
 * @author Matheus Lima Tavares da Costa
 */
public class ArrayList<T> implements Comparator<T>{
	private T[] objetos;
	private int posicao = 0;
	private Boolean achou = false;
	private static final int TAMANHOPADRAO = 12;

	/**
	 * Cria um array de tamanho padrão
	 */
	@SuppressWarnings("unchecked")
	public ArrayList() {
		this.objetos = (T[]) new Object[TAMANHOPADRAO];
	}

	/**
	 * Construtor do array com tamanho passado
	 * @param Especifica o tamanho do array
	 * @throws IllegalArgumentException é chamado toda vez que o tamanho passado for inválido
	 */
	@SuppressWarnings("unchecked")
	public ArrayList(int tamanho){
		if (tamanho < 1){
			throw new IllegalArgumentException();
		}else{
			//Como a instancia usada é de um Objeto qualquer não pode garantir o cast
			this.objetos = (T[]) new Object[tamanho];
		}
	}

	/**
	 * Função adciona objeto ao array
	 * @param objeto Representa o objeto a ser adicionado na lista
	 * @throws NullPointerException é chamado toda vez que o objeto passado for nulo
	 */
	public Boolean add(T objeto){
		verificaNulo(objeto);
		if(isEstourou()) {
			duplicaTamanho();
		}
		this.objetos[posicao] = objeto;
		posicao++;
		return true;
	}
	
	/**
	 * 
	 * @param objeto
	 * @return
	 * @throws NullPointerException é chamado toda vez que o objeto passado for nulo
	 */
	public Boolean addAll(ArrayList<T> objeto) {
		if(objeto == null) {
			throw new NullPointerException();
		}
		int tamanho = posicao + objeto.size();
		int cont = 0;
		for (int i = posicao; i < tamanho; i++) {
			this.objetos[posicao] = objeto.get(cont);
			posicao++;
			cont++;
		}
		return true;
	}

	/**
	 * Retorna elemento pelo indice
	 * @param index representa a posição do elemento
	 */
	public T get(int indice){
		if(indice >= posicao || indice < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return objetos[indice];
	}

	/**
	 * Procura pela primeira ocorrencia do objeto no array e retorna o indice dele
	 * @param objeto 
	 * @return retorna o indice do objeto no array se ele não for encontrado retorna -1
	 */
	public int indexOf(T objeto) {
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
	public int lastIndexOf(T objeto) {
		verificaNulo(objeto);
		int ultimaOcorrencia = -1;
		for (int i = 0; i < posicao; i++) {
			if(objeto.equals(objetos[i])) {
				ultimaOcorrencia = i;
			}
		}
		return ultimaOcorrencia;
	}
	
	/**
	 * Substitui o elemento na posição especificada
	 * @param indice
	 * @param elemento
	 */
	public void set(int indice, T elemento) {
		if(indice < 0 || indice >= posicao) {
			throw new IndexOutOfBoundsException();
		}
		this.objetos[indice] = elemento;
	}

	//Como a instancia usada é de um Objeto qualquer não pode garantir o cast
	@SuppressWarnings("unchecked")
	public void clear() {
		//atribuir uma nova instancia ou fazer um for atribuindo nulo?
		this.objetos = (T[]) new Object[TAMANHOPADRAO];
		posicao = 0;
	}

	/**
	 * Remove objeto do array pelo indice
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
	public void remove(T objeto) {
		verificaNulo(objeto);
		for (int i = 0; i < posicao; i++) {
			if(objetos[i].equals(objeto)) {
				objetos[i] = null;
				achou = true;
				break;
			}else if(!achou) {
				throw new NullPointerException();
			}
		}
		posicao--;

	}

	/**
	 * Metodo retorna uma copia da lista atual
	 */
	public ArrayList<T> clone() {
		//Como a instancia usada é de um Objeto qualquer não pode garantir o cast
		ArrayList<T> copia = new ArrayList<>();
		for (int i = 0; i < posicao; i++) {
			copia.add(this.objetos[i]);
		}
		return copia;
	}
	
//	public void sort(List<T> objeto){
//		Collections.sort(objeto);
//	}

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
		return this.objetos.length == posicao;
	}

	/**
	 * Retorna uma exceçao caso o objeto seja nulo
	 * @param objeto Representa o objeto a ser verificado
	 * @throws @throws NullPointerException é chamado toda vez que o objeto passado for nulo 
	 */
	public void verificaNulo(T objeto) {
		if(objeto == null) {
			throw new NullPointerException();
		}
	}

	/**
	 * Caso o array não tenha mais espaço essa função duplica o tamanho
	 * @param objetos
	 * @return
	 */
	public void duplicaTamanho() {
		int novoTamanho = objetos.length * 2;
		//Como a instancia usada é de um Objeto qualquer não pode garantir o cast
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[novoTamanho];
		for (int i = 0; i < objetos.length; i++) {
			temp[i] = objetos[i];
		}
		this.objetos = temp;
	}

	/**
	 * Caso seja usado o add com indice
	 * @param objetos
	 * @return
	 */
	public T[] aumentaUm(T[] objetos) {
		//Como a instancia usada é de um Objeto qualquer não pode garantir o cast
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[objetos.length + 1];
		for (int i = 0; i < objetos.length; i++) {
			temp[i] = objetos[i];
		}
		return temp;
	}

	/**
	 * Metódo para saber se um objeto se encontra no array
	 * @param objeto
	 * @return
	 */
	public Boolean isContain(T objeto) {
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
		return "ArrayList [objetos=" + Arrays.toString(objetos) + "]";
	}

	@Override
	public int compare(T o1, T o2) {
		return 0;
	}

}
