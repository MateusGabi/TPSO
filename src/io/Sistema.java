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
	 * Especifica��o n.i. cria um arquivo de nome narq e tamanho tamarq bytes.
	 * Verifica se o arquivo j� n�o existe e ent�o cria uma entrada no diret�rio
	 * e na lista de blocos livres.
	 * 
	 * @param narq
	 *            nome do arquivo
	 * @param tamarq
	 *            tamanho do arquivo
	 */
	public void criarArquivo(String narq, int tamarq) {

		/*
		 * N�o precisamos verifica se o arquivo j� n�o existe, pois
		 * hd.adicionarArquivo() j� verifica.
		 * 
		 * Cria uma entrada no diret�rio e na lista de blocos livres
		 */
		hd.adicionarArquivo(narq, tamarq);
	}

	/**
	 * Especifica��o n.ii. destr�i o arquivo de nome narq. Acessa o diret�rio
	 * para eliminar a entrada do arquivo solicitado e alterar a lista de blocos
	 * livres.
	 * 
	 * @param narq
	 *            nome do arquivo a ser removido
	 */
	public void destroiArquivo(String narq) {

		/* TODO Acessa o diret�rio para eliminar a entrada */
	}

	/**
	 * Especifica��o n.iii.
	 * 
	 * @param narq
	 *            nome do arquivo a ser varrido
	 */
	public void varreArquivo(String narq) {
		// TODO
	}

	/**
	 * Especifica��o n.iv
	 * 
	 * @param narq
	 * @param pos
	 * @param texto
	 */
	public void escreveArquivo(String narq, int pos, String texto) {
		// TODO
	}

	/**
	 * Especifica��o n.v
	 * 
	 * @param narq
	 * @param pos
	 * @param qtd
	 */
	public void leArquivo(String narq, int pos, int qtd) {

	}

}
