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

		/* O primeiro bloco � o bloco de diret�rio */
		vetor[0] = new BlocoDiretorio(numeroDeBlocos - 3, tamanhoMaximoEmBytes);

		/* O segundo bloco � o bloco com uma lista de Blocos Livres */
		vetor[1] = new BlocoLivre(numeroDeBlocos);

		/* do bloco 2 ao d - 1 s�o blocos de dados ou blocos de �ndices */

	}

	/**
	 * M�todo que retorna true caso exista arquivo com esse nome
	 * 
	 * @param narq
	 * @return
	 */
	public boolean existe(String narq) {
		return ((BlocoDiretorio) vetor[0]).existe(narq);
	}

	/**
	 * M�todo que adiciona um arquivo narq de tamanho tamarq bytes
	 * 
	 * @param narq
	 * @param tamarq
	 *            tamanho do arquivo em bytes
	 */
	public void adicionarArquivo(String narq, int tamarq) {

		// TODO

		/*
		 * Especifica��o l. A aloca��o de blocos ent�o realizada via aloca��o
		 * indexada usando um bloco de �ndice para cada arquivo.
		 * 
		 * Ent�o tenho que encontrar o primeiro espa�o dispon�vel no vetor e
		 * inserir um bloco de �ndice.
		 */

		int indiceDoBlocoIndice;
		for (indiceDoBlocoIndice = 0; indiceDoBlocoIndice < vetor.length; indiceDoBlocoIndice++) {
			if (vetor[indiceDoBlocoIndice] == null) {
				vetor[indiceDoBlocoIndice] = new BlocoIndice(vetor.length - 3);
				break;
			}
		}

		/*
		 * Reservar �ndices nesse array para o meu arquivo. N�mero m�ximo de
		 * posi��es vagas para um arquivo: d - 3. No qual cada bloco possui b
		 * bytes no m�ximo.
		 * 
		 * Logo, o n�mero de blocos que devem ser reservados para cada arquivo
		 * deve ser o teto de tamarq / b.
		 */

		double b = (double) tamanhoMaximoEmBytes;

		double blocosParaSeremReservados = Math.ceil(tamarq / b);

		/*
		 * Agora tenho que verificar se blocosParaSeremReservados � maior que a
		 * quantidade de blocos livres
		 */

	}
}
