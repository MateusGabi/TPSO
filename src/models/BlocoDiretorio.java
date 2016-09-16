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

		private Arquivo(String nome, int numeroDoBlocoIndice,
				int ponteiroDaPosicaoDentroDoArquivo) {
			super();

			for (int i = 0; i < 8; i++) {
				this.nome[i] = nome.charAt(i);
			}

			this.numeroDoBlocoIndice = numeroDoBlocoIndice;
			this.ponteiroDaPosicaoDentroDoArquivo = ponteiroDaPosicaoDentroDoArquivo;
		}

	}

	private final Arquivo[] arquivos;
	private int length;

	BlocoDiretorio(int maximoDeEntradas, int tamanhoMaximo) {

		arquivos = new Arquivo[maximoDeEntradas];
		length = 0;

	}

	public void adicionarArquivo(String nome) {
		if (nome.length() > 9) {
			System.out.println("Nome maior que o permitido.");
			return;
		}

		/* tentar colocar o arquivo no primeiro bloco de índice */

		/* caso não couber, criar um novo bloco de índice */

		/*
		 * temos um bloco de índice e agora precisamos inserir o nome do file e
		 * seu índice
		 */
	}
}
