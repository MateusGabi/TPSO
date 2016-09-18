package io;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class File {
	public void readCmd(String narq){
		String nome = narq;
		try {
			/* 
			 * arq = Variavel que recebe o arquivo a ser lido;
			 * Enquanto tiver comandos a serem lidos o arquivo vai ser
			 * lido!
			 */
			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			while (linha != null) {
				// lê da segunda até a última linha
				String cmd[] = linha.split(" ");
				if(cmd[1].equalsIgnoreCase("criar")){
					// sistema criarArquivo(cmd[1], cmd[2]);
				}
				if(cmd[1].equalsIgnoreCase("destroi")){
					// sistema destroiArquivo(cmd[1]);
				}
				if(cmd[1].equalsIgnoreCase("varre")){
					// sistema varreArquivo(cmd[1]);
				}
				if(cmd[1].equalsIgnoreCase("escreve")){
					// sistema escreveArquivo(cmd[1], (int)cmd[2], cmd[3]);
				}
				if(cmd[1].equalsIgnoreCase("le")){
					// sistema leArquivo(cmd[1], (int)cmd[2], cmd[3]);
				}
				linha = lerArq.readLine(); 
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
			e.getMessage());
		}
	}
}
