package models;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 
 * @author Mateus Gabi
 *
 */
public class BlocoIndice implements Bloco {

	/*
	 * Estrutura Chave-Valor no qual a chave � o nome do arquivo e o valor � a
	 * lista dos �ndices onde ele est�
	 */
	private final HashMap<String, LinkedList<Integer>> mapa;

	/* limite de inser��es: d - 3. Item k da especifica��o. */
	private final int limite;

	/* numero de entradas utilizados = mapa.get(this.name).size() */

	private final String name;

	/**
	 * 
	 * @param limite
	 *            limite de inser��es: d - 3. Item k da especifica��o.
	 * @param narq
	 *            nome do arquivo
	 */
	BlocoIndice(int limite, String narq) {
		this.limite = limite;
		this.mapa = new HashMap<String, LinkedList<Integer>>();

		/* adiciona o arquivo narq com 0 blocos de dados */
		mapa.put(narq, null);

		this.name = narq;
	}

	/**
	 * Retorna -1 caso o bloco de �ndice esteja cheio ou o indice do bloco
	 * adicionado
	 * 
	 * @param narq
	 * @return
	 */
	int adicionarArquivo(String narq, int indiceDesteBlocoDeIndice) {
		if (isCheio()) {
			return -1;
		}
		
		// TODO
		
		return 0;
	}

	/**
	 * Retorna o n�mero de Indices Utilizados
	 * 
	 * @return
	 */
	private int getUtilizados() {
		return mapa.get(this.name).size();
	}

	/**
	 * Retorna se o bloco est� cheio
	 * 
	 * @return
	 */
	private boolean isCheio() {
		return limite == getUtilizados();
	}

	/**
	 * Recebe uma lista de �ndices e seta
	 * 
	 * @param indicesDosBlocosDeDadosReservados
	 */
	public void setIndices(LinkedList<Integer> indicesDosBlocosDeDadosReservados) {

		/* Adicionamos o novo chave-valor */
		mapa.put(this.name, indicesDosBlocosDeDadosReservados);

	}

}
