package models;

import java.util.LinkedList;
import io.Logger;

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
		Logger.log("Disco inicializado com " + numeroDeBlocos
				+ " blocos de tamanho " + tamanhoMaximoEmBytes + " bytes.");

		/* d = numeroDeBlocos */
		/* b = tamanhoMaximoEmBytes */

		this.vetor = new Bloco[numeroDeBlocos];
		this.tamanhoMaximoEmBytes = tamanhoMaximoEmBytes;

		/* O primeiro bloco é o bloco de diretório */
		vetor[0] = new BlocoDiretorio(numeroDeBlocos - 3, tamanhoMaximoEmBytes);

		Logger.log("Bloco 0 é o Bloco do Diretório.");

		/* O segundo bloco é o bloco com uma lista de Blocos Livres */
		vetor[1] = new BlocoLivre(numeroDeBlocos);

		Logger.log("Bloco 1 armazena referências aos blocos livres.");

		/* do bloco 2 ao d - 1 são blocos de dados ou blocos de índices */

	}

	/**
	 * 
	 * @return diretório
	 */
	private BlocoDiretorio getDiretorio() {
		return (BlocoDiretorio) vetor[0];
	}

	/**
	 * 
	 * @return BlocoLivre
	 */
	private BlocoLivre getBlocosLivres() {
		return (BlocoLivre) vetor[1];
	}

	/**
	 * Método que retorna true caso exista arquivo com esse nome
	 * 
	 * @param narq
	 * @return
	 */
	private boolean existe(String narq) {
		return getDiretorio().existe(narq);
	}

	/**
	 * Método que adiciona um arquivo narq de tamanho tamarq bytes
	 * 
	 * @param narq
	 * @param tamarq
	 *            tamanho do arquivo em bytes
	 */
	public void adicionarArquivo(String narq, int tamarq) {

		/* Verifica se arquivo existe */
		if (this.existe(narq)) {

			Logger.log("Arquivo \"" + narq + "\" já existente");

			return;
		}

		/*
		 * Especificação l. A alocação de blocos então realizada via alocação
		 * indexada usando um bloco de índice para cada arquivo.
		 * 
		 * Então tenho que encontrar o primeiro espaço disponível no vetor e
		 * inserir um bloco de índice.
		 */

		/* Pegamos a lista de indices disponíveis */
		LinkedList<Integer> indicesLivres = this.getBlocosLivres()
				.getIndicesLivres();

		int indiceDoBlocoIndice = indicesLivres.get(0);

		/* Criamos um bloco de índice neles */
		vetor[indiceDoBlocoIndice] = new BlocoIndice(vetor.length - 3, narq);

		/* Inserimos o arquivo Bloco do Diretório */
		this.getDiretorio().adicionarArquivo(narq, tamarq, indiceDoBlocoIndice);

		Logger.log("Bloco " + indiceDoBlocoIndice
				+ " é o Bloco de índices do arquivo \"" + narq + "\".");

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

		if (getQuantidadeIndicesLivres() < blocosParaSeremReservados) {

			/* Não há espaço */

			Logger.log("Não há espaço em disco para este arquivo.");

			/* Devemos apagar o bloco de índice */
			vetor[indiceDoBlocoIndice] = null;

			return;

		}

		/* Caso ao contrário, há espaço e devemos reservar espaço para eles */

		LinkedList<Integer> indicesDosBlocosDeDadosReservados;
		indicesDosBlocosDeDadosReservados = new LinkedList<Integer>();

		/* começamos com i = 1 pois o 0 é o Bloco de índice */
		for (int i = 1; blocosParaSeremReservados-- > 0; i++) {

			/* Pegamos o termo i dos indicesLivres */

			int indice = indicesLivres.get(i);

			/* Adicionamos na lista de indices reservados */
			indicesDosBlocosDeDadosReservados.add(indice);

			/* Registramos o log */
			Logger.log("Bloco " + indice + " reservado ao arquivo \"" + narq
					+ "\".");

		}

		/* Adicionar ao bloco de índices os índices dos blocos de dados */
		((BlocoIndice) vetor[indiceDoBlocoIndice])
				.setIndices(indicesDosBlocosDeDadosReservados);

		/*
		 * Não podemos esquecer de adicionar o indice onde está o bloco de
		 * indices deste arquivo. Coloquei aqui para usarmos a mesma lista
		 * quando fomos marcar estes blocos como ocupados.
		 */
		indicesDosBlocosDeDadosReservados.add(indiceDoBlocoIndice);

		/* Remover índices da lista de blocos livres */
		this.getBlocosLivres().setIndicesComoOcupados(
				indicesDosBlocosDeDadosReservados);

		/* Registramos o log de quantos blocos livres estão disponíveis */
		Logger.log("Após a adição do arquivo \"" + narq + "\" há "
				+ getQuantidadeIndicesLivres() + " blocos livres.");

	}

	/**
	 * 
	 * @return quantidade de indices livres
	 */
	private int getQuantidadeIndicesLivres() {
		return this.getBlocosLivres().getIndicesLivres().size();
	}
}
