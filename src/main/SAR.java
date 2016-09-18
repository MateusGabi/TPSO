package main;

import io.Sistema;
import io.File;

public class SAR {

	public static void main(String[] args) {
		File arq = new File();
		arq.readCmd("Config.txt");
		/* 1 - Crie o sistema passando o número de blocos e o tamanho deles */
		Sistema sis = new Sistema(50, 100);

		/* Especificações n */

		/* i - Crie um arquivo com nome e tamanho */
		sis.criarArquivo("Arquivo1", 100);

		/* ii. destroi narq */
		/* destroi o arquivo de nome "Arquivo1" */
		sis.destroiArquivo("Arquivo1");
		
		/* iii. varre narq */
		/* imprime o conteúdo completo de "Arquivo1" */
		sis.varreArquivo("Arquivo1");
		
		
		/* iv. escreve narq pos texto: */
		/*
		 * Escreve no "Arquivo1" a partir da posição 3 o texto
		 * "Oi, eu sou o Goku!"
		 */
		sis.escreveArquivo("Arquivo1", 3, "Oi, eu sou o Goku!");
		/* v. le narq pos qtd: le qtd */

		/*
		 * Le 100 caracteres a partir do caracter 2 do arquivo de nome
		 * "Arquivo1"
		 */
		sis.leArquivo("Arquivo1", 2, 100);

	}

}
