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
	 * Especifica��o n.i. <br />
	 * <br />
	 * 
	 * cria um arquivo de nome <code>narq</code> e tamanho <code>tamarq</code>
	 * bytes. Verifica se o arquivo j� n�o existe e ent�o cria uma entrada no
	 * diret�rio e na lista de blocos livres.
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
	 * Especifica��o n.ii. <br />
	 * <br />
	 * 
	 * destr�i o arquivo de nome <code>narq</code>. Acessa o diret�rio para
	 * eliminar a entrada do arquivo solicitado e alterar a lista de blocos
	 * livres.
	 * 
	 * @param narq
	 *            nome do arquivo a ser removido
	 */
	public void destroiArquivo(String narq) {

		/*
		 * N�o precisamos verificar se o arquivo existe pois o hd verifica
		 */
		hd.destroiArquivo(narq);
	}

	/**
	 * Especifica��o n.iii. <br />
	 * <br />
	 * 
	 * varre o arquivo de nome <code>narq</code> sequencialmente desde o
	 * primeiro bloco at� o �ltimo, escrevendo na tela o conte�do de cada bloco.
	 * Acessa o diret�rio para realizar a varredura.
	 * 
	 * @param narq
	 *            nome do arquivo a ser varrido
	 */
	public void varreArquivo(String narq) {
		// TODO

		Logger.log("Fun��o varre arquivo n�o implementada.");
	}

	/**
	 * Especifica��o n.iv: <br />
	 * <br />
	 * 
	 * escreve o <code>texto</code> de no m�ximo 100 caracteres a partir da
	 * posi��o <code>pos</code> do arquivo de nome <code>narq</code>. Acessa e
	 * altera o diret�rio para realizar a escrita a partir da posi��o indicada
	 * sem extrapolar tamarq.
	 * 
	 * @param narq
	 *            nome do arquivo
	 * @param pos
	 *            posi��o do caracter inicial
	 * @param texto
	 *            texto que ser� substituido
	 */
	public void escreveArquivo(String narq, int pos, String texto) {
		// TODO

		Logger.log("Fun��o escreve arquivo n�o implementada.");
	}

	/**
	 * Especifica��o n.v:
	 * 
	 * le qtd caracteres a partir da posi��o pos do arquivo de nome narq. Acessa
	 * e altera o diret�rio para realizar a leitura a partir da posi��o indicada
	 * sem extrapolar tamarq.
	 * 
	 * @param narq
	 *            nome do arquivo
	 * @param pos
	 *            posi��o de leitura
	 * @param qtd
	 *            quantidade de caracteres a serem lidos
	 */
	public void leArquivo(String narq, int pos, int qtd) {

		// TODO

		Logger.log("Fun��o ler arquivo n�o implementada.");
	}

}
