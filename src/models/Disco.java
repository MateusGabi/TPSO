package models;

import java.util.LinkedList;

import util.Functions;
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

		int blocosLidos = 0;

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

		/* O primeiro bloco é o bloco de diretório */
		vetor[0] = new BlocoDiretorio(numeroDeBlocos - 3,
				tamanhoMaximoDosBlocosDeDados);

		blocosLidos++;

		Logger.log("Bloco 0 é o Bloco do Diretório.");

		/* O segundo bloco é o bloco com uma lista de Blocos Livres */
		vetor[1] = new BlocoLivre(numeroDeBlocos);

		blocosLidos++;

		Logger.log("Bloco 1 armazena referências aos blocos livres.");

		/* do bloco 2 ao d - 1 são blocos de dados ou blocos de índices */

		memoriaEmUso += 2 * tamanhoMaximoDosBlocosDeDados;

		Logger.log("Há " + getMemoriaDisponivel() + " Bytes disponíveis.");
		Logger.log("Para esta execução foram lidos " + blocosLidos + " blocos.");

	}

	private int getMemoriaDisponivel() {
		return tamanhoMaximoDoDisco - memoriaEmUso;
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

		int blocosLidos = 0;

		Logger.log("Criando arquivo \"" + narq + "\"...");

		/* Verifica se arquivo existe */
		if (existe(narq)) {

			Logger.log("Arquivo \"" + narq + "\" já existente");
			Logger.log("Para esta execução foram lidos " + blocosLidos
					+ " blocos.");

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

		blocosLidos++;

		int indiceDoBlocoIndice = indicesLivres.get(0);

		/* Criamos um bloco de índice neles */
		vetor[indiceDoBlocoIndice] = new BlocoIndice(vetor.length - 3, narq);
		blocosLidos++;

		/* Inserimos o arquivo Bloco do Diretório */
		this.getDiretorio().adicionarArquivo(narq, tamarq, indiceDoBlocoIndice);
		blocosLidos++;

		/*
		 * Reservar índices nesse array para o meu arquivo. Número máximo de
		 * posições vagas para um arquivo: d - 3. No qual cada bloco possui b
		 * bytes no máximo.
		 * 
		 * Logo, o número de blocos que devem ser reservados para cada arquivo
		 * deve ser o teto de tamarq / b.
		 */

		double b = (double) tamanhoDosBlocosDeDados;

		double blocosParaSeremReservados = Math.ceil(tamarq / b);

		int tamanhoDoUltimoBlocoDoArquivo = tamarq % tamanhoDosBlocosDeDados;

		/*
		 * Agora tenho que verificar se blocosParaSeremReservados é maior que a
		 * quantidade de blocos livres
		 */

		if (getQuantidadeIndicesLivres() < blocosParaSeremReservados) {

			/* Não há espaço */

			Logger.log("Não há espaço em disco para este arquivo.");

			/* Devemos apagar o bloco de índice */
			vetor[indiceDoBlocoIndice] = null;
			blocosLidos--;

			Logger.log("Para esta execução foram lidos " + blocosLidos
					+ " blocos.");

			return;

		}

		Logger.log("Bloco " + indiceDoBlocoIndice
				+ " é o Bloco de índices do arquivo \"" + narq + "\".");

		/* Caso ao contrário, há espaço e devemos reservar espaço para eles */

		LinkedList<Integer> indicesDosBlocosDeDadosReservados;
		indicesDosBlocosDeDadosReservados = new LinkedList<Integer>();

		memoriaEmUso += ((int) blocosParaSeremReservados + 1)
				* tamanhoDosBlocosDeDados;

		/* começamos com i = 1 pois o 0 é o Bloco de índice */
		for (int i = 1; blocosParaSeremReservados-- > 0; i++) {

			/* Pegamos o termo i dos indicesLivres */

			int indice = indicesLivres.get(i);

			/* Adicionamos na lista de indices reservados */
			indicesDosBlocosDeDadosReservados.add(indice);

		}

		/* Adicionar ao bloco de índices os índices dos blocos de dados */
		((BlocoIndice) vetor[indiceDoBlocoIndice])
				.setIndices(indicesDosBlocosDeDadosReservados);

		blocosLidos++;

		/* Criar blocos de dados */
		for (Integer i : indicesDosBlocosDeDadosReservados) {
			if (i != indiceDoBlocoIndice) {
				vetor[i] = new BlocoDados(tamanhoDosBlocosDeDados);
				if (i == indicesDosBlocosDeDadosReservados.getLast()) {
					vetor[i] = new BlocoDados(tamanhoDoUltimoBlocoDoArquivo);

				}

				blocosLidos++;

				Logger.log("Bloco de dados " + i + " reservado ao arquivo "
						+ narq + " com tamanho "
						+ ((BlocoDados) vetor[i]).getTamanho() + " Bytes.");

				((BlocoDados) vetor[i]).setCaracteres("[Valor Default]", 0);
			}
		}

		/*
		 * Não podemos esquecer de adicionar o indice onde está o bloco de
		 * indices deste arquivo. Coloquei aqui para usarmos a mesma lista
		 * quando fomos marcar estes blocos como ocupados.
		 */
		indicesDosBlocosDeDadosReservados.add(indiceDoBlocoIndice);

		/* Remover índices da lista de blocos livres */
		this.getBlocosLivres().setIndicesComoOcupados(
				indicesDosBlocosDeDadosReservados);
		blocosLidos++;

		/* Registramos o log de quantos blocos livres estão disponíveis */
		Logger.log("Após a adição do arquivo \"" + narq + "\" há "
				+ getQuantidadeIndicesLivres()
				+ " blocos livres. Memória Disponível: "
				+ getMemoriaDisponivel() + " Bytes.");

		Logger.log("Para esta execução foram lidos " + blocosLidos + " blocos.");

	}

	/**
	 * Método que remove um arquivo de nome <code>narq</code>
	 * 
	 * @param narq
	 */
	public void destroiArquivo(String narq) {

		int blocosLidos = 0;

		if (!existe(narq)) {
			/* Caso o arquivo não exista */

			blocosLidos++;

			Logger.log("Arquivo \"" + narq + "\" inexistente.");

			Logger.log("Para esta execução foram lidos " + blocosLidos
					+ " blocos.");

			return;
		}

		blocosLidos++;

		Logger.log("Removendo \"" + narq + "\"...");

		/*
		 * Se o arquivo existe temos que setar como nulo:
		 * 
		 * - Seus blocos de dados - Seu Bloco de índice
		 * 
		 * E adicionar no bloco livre os índices:
		 * 
		 * - dos blocos de dados - do bloco de índice
		 */

		/* Pegando o indice do bloco de indice */
		int indiceDoBlocoDeIndice = this.getDiretorio()
				.getIndiceDoBlocoDeIndice(narq);

		blocosLidos++;

		LinkedList<Integer> novosIndicesNulos = new LinkedList<Integer>();

		/* inserimos o indice do bloco de indice porque ele também será nulo */
		novosIndicesNulos.add(indiceDoBlocoDeIndice);

		BlocoIndice bi = (BlocoIndice) vetor[indiceDoBlocoDeIndice];

		blocosLidos++;

		/* pegamos todos os indices i dos blocos de dados */
		for (Integer i : bi.getIndicesDosBlocosDeDados()) {

			/* adicionamos esses indices na lista */
			novosIndicesNulos.add(i);

			/* tornamos nulos essa posição do array */
			vetor[i] = null;

			memoriaEmUso -= tamanhoDosBlocosDeDados;

			Logger.log("Excluindo dados do bloco " + i + "...");
		}

		Logger.log("Arquivo \"" + narq + "\" removido. Há "
				+ getMemoriaDisponivel() + " Bytes disponíveis.");

		/* Removemos o arquivo do diretorio */
		this.getDiretorio().destroiArquivo(narq);

		blocosLidos++;

		/* setamos como indices disponíveis */
		this.getBlocosLivres().setIndicesComoLivres(novosIndicesNulos);

		blocosLidos++;

		Logger.log("Para esta execução foram lidos " + blocosLidos + " blocos.");

	}

	/**
	 * 
	 * @return quantidade de indices livres
	 */
	private int getQuantidadeIndicesLivres() {
		return this.getBlocosLivres().getIndicesLivres().size();
	}

	/**
	 * Especificação n.iii. <br />
	 * <br />
	 * 
	 * varre o arquivo de nome <code>narq</code> sequencialmente desde o
	 * primeiro bloco até o último, escrevendo na tela o conteúdo de cada bloco.
	 * Acessa o diretório para realizar a varredura.
	 * 
	 * @param narq
	 *            nome do arquivo a ser varrido
	 */
	public void varreArquivo(String narq) {
		
		int blocosLidos = 0;

		/*
		 * Para varrer um arquivo devemos: 1 - Saber se existia 2 - Pegar os
		 * indices dos blocos de dados 3 - Pegar os caracteres
		 */

		if (!existe(narq)) {

			blocosLidos++;

			Logger.log("Arquivo \"" + narq + "\" inexistente.");

			Logger.log("Para esta execução foram lidos " + blocosLidos
					+ " blocos.");

			return;

		}

		LinkedList<Integer> blocosDados = ((BlocoIndice) vetor[this
				.getDiretorio().getIndiceDoBlocoDeIndice(narq)])
				.getIndicesDosBlocosDeDados();

		blocosLidos += 2;

		String texto = "";
		
		for (int i = 0; i < blocosDados.size() - 1; i++) {
			texto += ((BlocoDados) vetor[blocosDados.get(i)]).getCaracteres();

			blocosLidos++;
		}

		Logger.log("Arquivo \"" + narq + "\"");
		Logger.log(texto);

		Logger.log("Para esta execução foram lidos " + blocosLidos + " blocos.");

	}

	/**
	 * Especificação n.iv: <br />
	 * <br />
	 * 
	 * escreve o <code>texto</code> de no máximo 100 caracteres a partir da
	 * posição <code>pos</code> do arquivo de nome <code>narq</code>. Acessa e
	 * altera o diretório para realizar a escrita a partir da posição indicada
	 * sem extrapolar tamarq.
	 * 
	 * @param narq
	 *            nome do arquivo
	 * @param pos
	 *            posição do caracter inicial
	 * @param texto
	 *            texto que será substituido
	 */
	public void escreveArquivo(String narq, int pos, String texto) {

		Logger.log("Inicializando escrita no arquivo \"" + narq + "\"...");

		/*
		 * Para escrever no arquivo temos que verificar se o arquivo existe. Se
		 * o arquivo existe, qual bloco está a posição e a partir dessa posição,
		 * setar os 100 caracteres
		 */

		int blocosLidos = 0;

		narq = Functions.formatarStringNomeDoArquivo(narq);

		if (!existe(narq)) {

			blocosLidos++;

			Logger.log("Arquivo \"" + narq + "\" inexistente.");

			Logger.log("Para esta execução foram lidos " + blocosLidos
					+ " blocos.");

			return;

		}

		/* Pegamos os indices dos blocos de dados */

		LinkedList<Integer> blocosDados = ((BlocoIndice) vetor[this
				.getDiretorio().getIndiceDoBlocoDeIndice(narq)])
				.getIndicesDosBlocosDeDados();

		/* Precisamos saber em qual bloco está a posição desejada */

		/* se der "2", indica que é o segundo bloco */
		int numeroBloco = pos / tamanhoDosBlocosDeDados;

		int posicaoDentroDoBloco = pos % tamanhoDosBlocosDeDados;

		BlocoDados bloco = ((BlocoDados) vetor[blocosDados.get(numeroBloco)]);

		blocosLidos += 2;

		int i = 0;
		int limite = tamanhoDosBlocosDeDados - posicaoDentroDoBloco;
		while (true) {

			if (limite > texto.length()) {
				limite = texto.length();
			}
			bloco.setCaracteres(texto.substring(i, limite),
					posicaoDentroDoBloco);
			
			if (limite == texto.length()) {
				break;
			}

			blocosLidos++;

			posicaoDentroDoBloco = 0;
			i = limite;
			limite = limite + tamanhoDosBlocosDeDados;

			if (limite > 101) {
				limite = 101;
			}

			numeroBloco++;

			if (numeroBloco > blocosDados.size() - 2) {
				break;
			}

			bloco = ((BlocoDados) vetor[blocosDados.get(numeroBloco)]);

			blocosLidos += 2;

		}

		Logger.log("Para esta execução foram lidos " + blocosLidos + " blocos.");

	}
}
