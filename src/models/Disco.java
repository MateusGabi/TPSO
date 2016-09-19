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
	private final int tamanhoDosBlocosDeDados;
	private final int tamanhoMaximoDoDisco;
	private int memoriaEmUso;

	/**
	 * 
	 * @param numeroDeBlocos
	 *            d = numero de blocos
	 * @param tamanhoMaximoDosBlocosDeDados
	 *            b = tamanho de cada bloco em bytes
	 */
	public Disco(int numeroDeBlocos, int tamanhoMaximoDosBlocosDeDados) {

		/* d = numeroDeBlocos */
		/* b = tamanhoMaximoEmBytes */

		this.vetor = new Bloco[numeroDeBlocos];
		this.tamanhoDosBlocosDeDados = tamanhoMaximoDosBlocosDeDados;

		this.tamanhoMaximoDoDisco = numeroDeBlocos
				* tamanhoMaximoDosBlocosDeDados;

		Logger.log("Disco inicializado com " + numeroDeBlocos
				+ " blocos de tamanho " + tamanhoMaximoDosBlocosDeDados
				+ " bytes. Tamanho total do disco: " + tamanhoMaximoDoDisco
				+ " Bytes;");

		/* O primeiro bloco � o bloco de diret�rio */
		vetor[0] = new BlocoDiretorio(numeroDeBlocos - 3,
				tamanhoMaximoDosBlocosDeDados);

		Logger.log("Bloco 0 � o Bloco do Diret�rio.");

		/* O segundo bloco � o bloco com uma lista de Blocos Livres */
		vetor[1] = new BlocoLivre(numeroDeBlocos);

		Logger.log("Bloco 1 armazena refer�ncias aos blocos livres.");

		/* do bloco 2 ao d - 1 s�o blocos de dados ou blocos de �ndices */

		memoriaEmUso += 2 * tamanhoMaximoDosBlocosDeDados;

		Logger.log("H� " + getMemoriaDisponivel() + " Bytes dispon�veis.");

	}

	private int getMemoriaDisponivel() {
		return tamanhoMaximoDoDisco - memoriaEmUso;
	}

	/**
	 * 
	 * @return diret�rio
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
	 * M�todo que retorna true caso exista arquivo com esse nome
	 * 
	 * @param narq
	 * @return
	 */
	private boolean existe(String narq) {
		return getDiretorio().existe(narq);
	}

	/**
	 * M�todo que adiciona um arquivo narq de tamanho tamarq bytes
	 * 
	 * @param narq
	 * @param tamarq
	 *            tamanho do arquivo em bytes
	 */
	public void adicionarArquivo(String narq, int tamarq) {
		
		Logger.log("Criando arquivo \"" + narq + "\"...");

		/* Verifica se arquivo existe */
		if (this.existe(narq)) {

			Logger.log("Arquivo \"" + narq + "\" j� existente");

			return;
		}

		/*
		 * Especifica��o l. A aloca��o de blocos ent�o realizada via aloca��o
		 * indexada usando um bloco de �ndice para cada arquivo.
		 * 
		 * Ent�o tenho que encontrar o primeiro espa�o dispon�vel no vetor e
		 * inserir um bloco de �ndice.
		 */

		/* Pegamos a lista de indices dispon�veis */
		LinkedList<Integer> indicesLivres = this.getBlocosLivres()
				.getIndicesLivres();

		int indiceDoBlocoIndice = indicesLivres.get(0);

		/* Criamos um bloco de �ndice neles */
		vetor[indiceDoBlocoIndice] = new BlocoIndice(vetor.length - 3, narq);

		/* Inserimos o arquivo Bloco do Diret�rio */
		this.getDiretorio().adicionarArquivo(narq, tamarq, indiceDoBlocoIndice);

		Logger.log("Bloco " + indiceDoBlocoIndice
				+ " � o Bloco de �ndices do arquivo \"" + narq + "\".");

		/*
		 * Reservar �ndices nesse array para o meu arquivo. N�mero m�ximo de
		 * posi��es vagas para um arquivo: d - 3. No qual cada bloco possui b
		 * bytes no m�ximo.
		 * 
		 * Logo, o n�mero de blocos que devem ser reservados para cada arquivo
		 * deve ser o teto de tamarq / b.
		 */

		double b = (double) tamanhoDosBlocosDeDados;

		double blocosParaSeremReservados = Math.ceil(tamarq / b);

		/*
		 * Agora tenho que verificar se blocosParaSeremReservados � maior que a
		 * quantidade de blocos livres
		 */

		if (getQuantidadeIndicesLivres() < blocosParaSeremReservados) {

			/* N�o h� espa�o */

			Logger.log("N�o h� espa�o em disco para este arquivo.");

			/* Devemos apagar o bloco de �ndice */
			vetor[indiceDoBlocoIndice] = null;

			return;

		}

		/* Caso ao contr�rio, h� espa�o e devemos reservar espa�o para eles */

		LinkedList<Integer> indicesDosBlocosDeDadosReservados;
		indicesDosBlocosDeDadosReservados = new LinkedList<Integer>();

		memoriaEmUso += ((int) blocosParaSeremReservados + 1)
				* tamanhoDosBlocosDeDados;

		/* come�amos com i = 1 pois o 0 � o Bloco de �ndice */
		for (int i = 1; blocosParaSeremReservados-- > 0; i++) {

			/* Pegamos o termo i dos indicesLivres */

			int indice = indicesLivres.get(i);

			/* Adicionamos na lista de indices reservados */
			indicesDosBlocosDeDadosReservados.add(indice);

			/* Registramos o log */
			Logger.log("Bloco " + indice + " reservado ao arquivo \"" + narq
					+ "\".");

		}

		/* Adicionar ao bloco de �ndices os �ndices dos blocos de dados */
		((BlocoIndice) vetor[indiceDoBlocoIndice])
				.setIndices(indicesDosBlocosDeDadosReservados);

		/*
		 * N�o podemos esquecer de adicionar o indice onde est� o bloco de
		 * indices deste arquivo. Coloquei aqui para usarmos a mesma lista
		 * quando fomos marcar estes blocos como ocupados.
		 */
		indicesDosBlocosDeDadosReservados.add(indiceDoBlocoIndice);

		/* Remover �ndices da lista de blocos livres */
		this.getBlocosLivres().setIndicesComoOcupados(
				indicesDosBlocosDeDadosReservados);

		/* Registramos o log de quantos blocos livres est�o dispon�veis */
		Logger.log("Ap�s a adi��o do arquivo \"" + narq + "\" h� "
				+ getQuantidadeIndicesLivres()
				+ " blocos livres. Mem�ria Dispon�vel: "
				+ getMemoriaDisponivel() + " Bytes.");

	}

	/**
	 * M�todo que remove um arquivo de nome <code>narq</code>
	 * 
	 * @param narq
	 */
	public void destroiArquivo(String narq) {

		if (!existe(narq)) {
			/* Caso o arquivo n�o exista */

			Logger.log("Arquivo \"" + narq + "\" inexistente.");

			return;
		}

		Logger.log("Removendo \"" + narq + "\"...");

		/*
		 * Se o arquivo existe temos que setar como nulo:
		 * 
		 * - Seus blocos de dados - Seu Bloco de �ndice
		 * 
		 * E adicionar no bloco livre os �ndices:
		 * 
		 * - dos blocos de dados - do bloco de �ndice
		 */

		/* Pegando o indice do bloco de indice */
		int indiceDoBlocoDeIndice = this.getDiretorio()
				.getIndiceDoBlocoDeIndice(narq);

		LinkedList<Integer> novosIndicesNulos = new LinkedList<Integer>();

		/* inserimos o indice do bloco de indice porque ele tamb�m ser� nulo */
		novosIndicesNulos.add(indiceDoBlocoDeIndice);

		BlocoIndice bi = (BlocoIndice) vetor[indiceDoBlocoDeIndice];

		/* pegamos todos os indices i dos blocos de dados */
		for (Integer i : bi.getIndicesDosBlocosDeDados()) {

			/* adicionamos esses indices na lista */
			novosIndicesNulos.add(i);

			/* tornamos nulos essa posi��o do array */
			vetor[i] = null;

			memoriaEmUso -= tamanhoDosBlocosDeDados;

			Logger.log("Excluindo dados do bloco " + i);
		}

		Logger.log("Arquivo \"" + narq + "\" removido. H� "
				+ getMemoriaDisponivel() + " Bytes dispon�veis.");

		/* Removemos o arquivo do diretorio */
		this.getDiretorio().destroiArquivo(narq);

		/* setamos como indices dispon�veis */
		this.getBlocosLivres().setIndicesComoLivres(novosIndicesNulos);

	}

	/**
	 * 
	 * @return quantidade de indices livres
	 */
	private int getQuantidadeIndicesLivres() {
		return this.getBlocosLivres().getIndicesLivres().size();
	}
}
