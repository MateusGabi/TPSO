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
	
	
	public Disco(int numeroDeBlocos, int tamanhoMaximoEmBytes) {
		
		/* d = numeroDeBlocos */
		
		this.vetor = new Bloco[numeroDeBlocos];
		this.tamanhoMaximoEmBytes = tamanhoMaximoEmBytes;
		
		/* O primeiro bloco é o bloco de diretório */
		vetor[0] = new BlocoDiretorio(numeroDeBlocos - 3, tamanhoMaximoEmBytes);
		
		/* O segundo bloco é o bloco com uma lista de Blocos Livres*/
		vetor[1] = new BlocoLivre();
		
		/* Bloco de indices */
		vetor[2] = new BlocoIndice();
		
		/* do bloco 3 ao d - 1 são blocos de dados */
		
	}
	
}
