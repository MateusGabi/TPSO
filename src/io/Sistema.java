package io;

import models.Disco;

/**
 * @author Mateus Gabi
 *
 */
public class Sistema {

	private final Disco hd;

	public Sistema(int numeroDeBlocos, int tamanhoMaximoEmBytes) {		
		
		Logger.log("Sistema inicializado");
		this.hd = new Disco(numeroDeBlocos, tamanhoMaximoEmBytes);
	}

	/**
	 * Especificação n.i. cria um arquivo de nome narq e tamanho tamarq bytes.
	 * Verifica se o arquivo já não existe e então cria uma entrada no diretório
	 * e na lista de blocos livres.
	 * 
	 * @param narq
	 *            nome do arquivo
	 * @param tamarq
	 *            tamanho do arquivo
	 */
	public void criarArquivo(String narq, int tamarq) {

		/*
		 * Não precisamos verifica se o arquivo já não existe, pois
		 * hd.adicionarArquivo() já verifica.
		 * 
		 * Cria uma entrada no diretório e na lista de blocos livres
		 */
		hd.adicionarArquivo(narq, tamarq);
	}

	/**
	 * Especificação n.ii. destrói o arquivo de nome narq. Acessa o diretório
	 * para eliminar a entrada do arquivo solicitado e alterar a lista de blocos
	 * livres.
	 * 
	 * @param narq
	 *            nome do arquivo a ser removido
	 */
	public void destroiArquivo(String narq) {

		/* TODO Acessa o diretório para eliminar a entrada */
	}

	/**
	 * Especificação n.iii.
	 * 
	 * @param narq
	 *            nome do arquivo a ser varrido
	 */
	public void varreArquivo(String narq) {
		// TODO
	}

	/**
	 * Especificação n.iv
	 * 
	 * @param narq
	 * @param pos
	 * @param texto
	 */
	public void escreveArquivo(String narq, int pos, String texto) {
		// TODO
	}

	/**
	 * Especificação n.v
	 * 
	 * @param narq
	 * @param pos
	 * @param qtd
	 */
	public void leArquivo(String narq, int pos, int qtd) {

	}

}
