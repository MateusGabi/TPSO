package models;

/**
 * 
 * @author Mateus Gabi
 *
 */
public class BlocoDiretorio implements Bloco {

	private class Arquivo {
		private char[] nome = new char[8];
		private int numeroDoBlocoIndice;
		private int ponteiroDaPosicaoDentroDoArquivo;
		private int tamarq;

		private Arquivo(String nome, int numeroDoBlocoIndice,
				int ponteiroDaPosicaoDentroDoArquivo, int tamarq) {
			super();

			for (int i = 0; i < 8; i++) {
				this.nome[i] = nome.charAt(i);
			}

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
	public void adicionarArquivo(String narq, int tamarq) {
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
