package models;

import java.awt.font.NumericShaper;

/**
 * 
 * @author Mateus Gabi
 * @author Pedro Henrique
 *
 */
public class Disco {

	private final Bloco[] vetor;
	private final int tamanhoMaximoEmBytes;

	/**
	 * 
	 * @param numeroDeBlocos
	 *            d = numero de blocos
	 * @param tamanhoMaximoEmBytes
	 *            b = tamanho de cada bloco em bytes
	 */
	public Disco(int numeroDeBlocos, int tamanhoMaximoEmBytes) {

		/* d = numeroDeBlocos */
		/* b = tamanhoMaximoEmBytes */

		this.vetor = new Bloco[numeroDeBlocos];
		this.tamanhoMaximoEmBytes = tamanhoMaximoEmBytes;

		/* O primeiro bloco é o bloco de diretório */
		vetor[0] = new BlocoDiretorio(numeroDeBlocos - 3, tamanhoMaximoEmBytes);

		/* O segundo bloco é o bloco com uma lista de Blocos Livres */
		vetor[1] = new BlocoLivre(numeroDeBlocos);

		/* do bloco 2 ao d - 1 são blocos de dados ou blocos de índices */

	}

	/**
	 * Método que retorna true caso exista arquivo com esse nome
	 * 
	 * @param narq
	 * @return
	 */
	public boolean existe(String narq) {
		return ((BlocoDiretorio) vetor[0]).existe(narq);
	}

	/**
	 * Método que adiciona um arquivo narq de tamanho tamarq bytes
	 * 
	 * @param narq
	 * @param tamarq
	 *            tamanho do arquivo em bytes
	 */
	public void adicionarArquivo(String narq, int tamarq) {

		// TODO

		/*
		 * Especificação l. A alocação de blocos então realizada via alocação
		 * indexada usando um bloco de índice para cada arquivo.
		 * 
		 * Então tenho que encontrar o primeiro espaço disponível no vetor e
		 * inserir um bloco de índice.
		 */

		int indiceDoBlocoIndice;
		for (indiceDoBlocoIndice = 0; indiceDoBlocoIndice < vetor.length; indiceDoBlocoIndice++) {
			if (vetor[indiceDoBlocoIndice] == null) {
				vetor[indiceDoBlocoIndice] = new BlocoIndice(vetor.length - 3);
				break;
			}
		}

		/*
		 * Reservar índices nesse array para o meu arquivo. Número máximo de
		 * posições vagas para um arquivo: d - 3. No qual cada bloco possui b
		 * bytes no máximo.
		 * 
		 * Logo, o número de blocos que devem ser reservados para cada arquivo
		 * deve ser o teto de tamarq / b.
		 */

		double b = (double) tamanhoMaximoEmBytes;

		double blocosParaSeremReservados = Math.ceil(tamarq / b);

		/*
		 * Agora tenho que verificar se blocosParaSeremReservados é maior que a
		 * quantidade de blocos livres
		 */

	}
}
