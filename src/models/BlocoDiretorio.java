package models;

public class BlocoDiretorio extends Bloco {
	
	private class Node {
		private char[] nome = new char[8];
		private int numeroDoBlocoIndice;
		private int ponteiroDaPosicaoDentroDoArquivo;

	}
	
	private final Node[] entradas;
	private int length;
	

	public BlocoDiretorio(int maximoDeEntradas, int tamanhoMaximo) {
		
		super(maximoDeEntradas, tamanhoMaximo);
		
		entradas = new Node[maximoDeEntradas];
		length = 0;
		
	}

}
