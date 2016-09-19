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
	 * Especificação n.i. <br />
	 * <br />
	 * 
	 * cria um arquivo de nome <code>narq</code> e tamanho <code>tamarq</code>
	 * bytes. Verifica se o arquivo já não existe e então cria uma entrada no
	 * diretório e na lista de blocos livres.
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
	 * Especificação n.ii. <br />
	 * <br />
	 * 
	 * destrói o arquivo de nome <code>narq</code>. Acessa o diretório para
	 * eliminar a entrada do arquivo solicitado e alterar a lista de blocos
	 * livres.
	 * 
	 * @param narq
	 *            nome do arquivo a ser removido
	 */
	public void destroiArquivo(String narq) {

		/*
		 * Não precisamos verificar se o arquivo existe pois o hd verifica
		 */
		hd.destroiArquivo(narq);
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
		// TODO

		Logger.log("Função varre arquivo não implementada.");
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
		// TODO

		Logger.log("Função escreve arquivo não implementada.");
	}

	/**
	 * Especificação n.v:
	 * 
	 * le qtd caracteres a partir da posição pos do arquivo de nome narq. Acessa
	 * e altera o diretório para realizar a leitura a partir da posição indicada
	 * sem extrapolar tamarq.
	 * 
	 * @param narq
	 *            nome do arquivo
	 * @param pos
	 *            posição de leitura
	 * @param qtd
	 *            quantidade de caracteres a serem lidos
	 */
	public void leArquivo(String narq, int pos, int qtd) {

		// TODO

		Logger.log("Função ler arquivo não implementada.");
	}

}
