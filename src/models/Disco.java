package models;

/**
 * 
 * @author Mateus Gabi
 * @author Pedro Henrique
 *
 */
public class Disco {

	private final Bloco[] vetor;
	private final int tamanhoMaximoEmBytes;

	Disco(int numeroDeBlocos, int tamanhoMaximoEmBytes) {

		/* d = numeroDeBlocos */

		this.vetor = new Bloco[numeroDeBlocos];
		this.tamanhoMaximoEmBytes = tamanhoMaximoEmBytes;

		/* O primeiro bloco � o bloco de diret�rio */
		vetor[0] = new BlocoDiretorio(numeroDeBlocos - 3, tamanhoMaximoEmBytes);

		/* O segundo bloco � o bloco com uma lista de Blocos Livres */
		vetor[1] = new BlocoLivre(numeroDeBlocos);

		/* do bloco 2 ao d - 1 s�o blocos de dados ou blocos de �ndices */

	}

}
