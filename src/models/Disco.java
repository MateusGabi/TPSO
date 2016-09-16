package models;

/**
 * 
 * @author Mateus Gabi
 * @author Pedro Henrique
 *
 */
public class Disco {

	private final Bloco[] array;
	private final int tamanhoMaximoEmBytes;
	
	
	public Disco(int numeroDeBlocos, int tamanhoMaximoEmBytes) {
		
		this.array = new Bloco[numeroDeBlocos];
		this.tamanhoMaximoEmBytes = tamanhoMaximoEmBytes;
		
		/* O primeiro bloco é o bloco de diretório */
		array[0] = new BlocoDiretorio(numeroDeBlocos - 3, tamanhoMaximoEmBytes);
		
	}
	
}
