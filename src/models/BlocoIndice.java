package models;

import java.util.HashMap;

/**
 * 
 * @author Mateus Gabi
 *
 */
public class BlocoIndice implements Bloco {

	/*
	 * Estrutura Chave-Valor no qual a chave � o nome do arquivo e o valor � o
	 * �ndice onde ele est�
	 */
	private final HashMap<String, Integer> mapa;

	/* limite de inser��es: d - 3. Item k da especifica��o. */
	private final int limite;

	BlocoIndice(int limite) {
		this.limite = limite;
		this.mapa = new HashMap<String, Integer>();
	}

}
