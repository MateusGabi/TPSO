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

	/* numero de entradas utilizados */
	private int utilizados;

	BlocoIndice(int limite) {
		this.limite = limite;
		this.mapa = new HashMap<String, LinkedList<Integer>>();
	}

	/**
	 * Retorna -1 caso o bloco de �ndice esteja cheio ou o indice do bloco
	 * adicionado
	 * 
	 * @param narq
	 * @return
	 */
	int adicionarArquivo(String narq, int indiceDesteBlocoDeIndice) {
		return 0;
	}

	int getUtilizados() {
		return utilizados;
	}

	boolean isCheio() {
		return limite == utilizados;
	}

}
