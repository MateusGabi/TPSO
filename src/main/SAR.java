package main;

import io.Sistema;

public class SAR {

	public static void main(String[] args) {
		
		/* 1 - Crie o sistema passando o número de blocos e o tamanho deles */
		Sistema sis = new Sistema(50, 100);
		
		/* 2 - Crie um arquivo com nome e tamanho */
		sis.criarArquivo("Arquivo1", 100);
		
		sis.criarArquivo("Arquivo1", 100);
		
	}

}
