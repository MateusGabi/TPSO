package models;

import java.util.HashMap;

/**
 * 
 * @author Mateus Gabi
 *
 */
public class BlocoIndice implements Bloco {

	/*
	 * Estrutura Chave-Valor no qual a chave é o nome do arquivo e o valor é o
	 * índice onde ele está
	 */
	private final HashMap<String, Integer> mapa;

	/* limite de inserções: d - 3. Item k da especificação. */
	private final int limite;

	BlocoIndice(int limite) {
		this.limite = limite;
		this.mapa = new HashMap<String, Integer>();
	}

}
