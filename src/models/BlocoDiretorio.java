package models;

import java.util.LinkedList;

import util.Functions;

/**
 * 
 * @author Mateus Gabi
 *
 */
public class BlocoDiretorio implements Bloco {

	private class Arquivo {
		private String nome;
		private final int numeroDoBlocoIndice;
		private int ponteiroDaPosicaoDentroDoArquivo;
		private final int tamarq;

		public Arquivo(String nome, int numeroDoBlocoIndice,
				int ponteiroDaPosicaoDentroDoArquivo, int tamarq) {

			this.nome = nome;
			this.numeroDoBlocoIndice = numeroDoBlocoIndice;
			this.ponteiroDaPosicaoDentroDoArquivo = ponteiroDaPosicaoDentroDoArquivo;
			this.tamarq = tamarq;

		}

		String getNome() {
			return nome;
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

		narq = Functions.formatarStringNomeDoArquivo(narq);

		/* Especificação o */
		int ponteiroDaPosicaoDentroDoArquivo = 0;

		arquivos.add(new Arquivo(narq, numeroDoBlocoIndice,
				ponteiroDaPosicaoDentroDoArquivo, tamarq));

	}

	/**
	 * Recebe um nome de um arquivo e retorna true caso exista ou false caso não
	 * 
	 * @param narq
	 * @return
	 */
	public boolean existe(String narq) {

		narq = Functions.formatarStringNomeDoArquivo(narq);

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

		narq = Functions.formatarStringNomeDoArquivo(narq);

		for (Arquivo arquivo : arquivos) {
			if (arquivo.getNome().equalsIgnoreCase(narq)) {
				return arquivo.getIndiceDoBlocoDeIndice();
			}
		}

		return -1;
	}

	void destroiArquivo(String narq) {		

		narq = Functions.formatarStringNomeDoArquivo(narq);
		
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
