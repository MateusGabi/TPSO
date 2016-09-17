package models;

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

	}

	private final Arquivo[] arquivos;
	private int numeroDeArquivos;

	BlocoDiretorio(int maximoDeEntradas, int tamanhoMaximo) {

		arquivos = new Arquivo[maximoDeEntradas];
		numeroDeArquivos = 0;

	}

	/**
	 * Adiciona um arquivo e assumindo que já foi verificado se o arquivo existe
	 * 
	 * @param narq
	 * @param tamarq
	 */
	public void adicionarArquivo(String narq, int tamarq,
			int numeroDoBlocoIndice) {

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

		arquivos[numeroDeArquivos] = new Arquivo(nome, numeroDoBlocoIndice,
				ponteiroDaPosicaoDentroDoArquivo, tamarq);

		numeroDeArquivos++;

	}

	/**
	 * Recebe um nome de um arquivo e retorna true caso exista ou false caso não
	 * 
	 * @param narq
	 * @return
	 */
	public boolean existe(String narq) {

		int n = numeroDeArquivos;

		for (int i = 0; i < n; i++) {
			if (arquivos[i].getNome().equalsIgnoreCase(narq)) {
				return true;
			}
		}

		return false;
	}

	public int getNumeroDeArquivos() {
		return numeroDeArquivos;
	}

}
