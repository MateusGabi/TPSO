package models;

import java.util.LinkedList;

/**
 * 
 * @author Mateus Gabi
 *
 */
public class BlocoDiretorio implements Bloco {

	private class Arquivo {
		private char[] nome = new char[8];
		private final int numeroDoBlocoIndice;
		private int ponteiroDaPosicaoDentroDoArquivo;
		private final int tamarq;

		public Arquivo(char[] nome, int numeroDoBlocoIndice,
				int ponteiroDaPosicaoDentroDoArquivo, int tamarq) {

			this.nome = nome;
			this.numeroDoBlocoIndice = numeroDoBlocoIndice;
			this.ponteiroDaPosicaoDentroDoArquivo = ponteiroDaPosicaoDentroDoArquivo;
			this.tamarq = tamarq;

		}

		String getNome() {
			return new String(nome);
		}

		int getIndiceDoBlocoDeIndice() {
			return numeroDoBlocoIndice;
		}

	}

	private final LinkedList<Arquivo> arquivos;
	private final int maximoDeEntradas;

	BlocoDiretorio(int maximoDeEntradas, int tamanhoMaximo) {

		arquivos = new LinkedList<BlocoDiretorio.Arquivo>();
		this.maximoDeEntradas = maximoDeEntradas;

	}

	/**
	 * Adiciona um arquivo e assumindo que já foi verificado se o arquivo existe
	 * 
	 * @param narq
	 * @param tamarq
	 */
	void adicionarArquivo(String narq, int tamarq, int numeroDoBlocoIndice) {

		/* Processando String para char */
		char[] nome = new char[8];
		for (int i = 0; i < narq.length(); i++) {
			if (i == 8) {
				break;
			}

			nome[i] = narq.charAt(i);
		}

		/* Especificação o */
		int ponteiroDaPosicaoDentroDoArquivo = 0;

		arquivos.add(new Arquivo(nome, numeroDoBlocoIndice,
				ponteiroDaPosicaoDentroDoArquivo, tamarq));

	}

	/**
	 * Recebe um nome de um arquivo e retorna true caso exista ou false caso não
	 * 
	 * @param narq
	 * @return
	 */
	public boolean existe(String narq) {

		for (Arquivo arquivo : arquivos) {
			if (arquivo.getNome().equalsIgnoreCase(narq)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Retorna -1 caso arquivo não exista ou i > 0
	 * 
	 * @param narq
	 * @return
	 */
	public int getIndiceDoBlocoDeIndice(String narq) {
		for (Arquivo arquivo : arquivos) {
			if (arquivo.getNome().equalsIgnoreCase(narq)) {
				return arquivo.getIndiceDoBlocoDeIndice();
			}
		}

		return -1;
	}

	void destroiArquivo(String narq) {
		int i = 0;
		for (Arquivo arquivo : arquivos) {
			if (arquivo.getNome().equalsIgnoreCase(narq)) {
				arquivos.remove(i);
				break;
			}
			i++;
		}
	}
}
