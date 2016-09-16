package models;

/**
 * 
 * Este bloco pode ser uma lista de blocos livres ou um bloco de índice
 * 
 * @author Mateus Gabi
 * @author Pedro Henrique
 *
 */
class Bloco {

	private int maximoDeEntradas;
	private int tamanhoMaximo;

	public Bloco(int maximoDeEntradas, int tamanhoMaximo) {
		super();
		this.maximoDeEntradas = maximoDeEntradas;
		this.tamanhoMaximo = tamanhoMaximo;
	}

}
