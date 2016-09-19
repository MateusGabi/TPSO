package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.LinkedList;

public class File {
	private void read(String narq) {
		Logger.log("Arquivo de CMD sendo lido");
		String nome = narq;
		try {
			/*
			 * arq = Variavel que recebe o arquivo a ser lido; Enquanto tiver
			 * comandos a serem lidos o arquivo vai ser lido!
			 * 
			 * @author Pedro Henrique
			 */
			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			while (linha != null) {
				// lê da segunda até a última linha
				String cmd[] = linha.split(" ");
				if (cmd[1].equalsIgnoreCase("criar")) {
					// sistema criarArquivo(cmd[1], cmd[2]);
				}
				if (cmd[1].equalsIgnoreCase("destroi")) {
					// sistema destroiArquivo(cmd[1]);
				}
				if (cmd[1].equalsIgnoreCase("varre")) {
					// sistema varreArquivo(cmd[1]);
				}
				if (cmd[1].equalsIgnoreCase("escreve")) {
					// sistema escreveArquivo(cmd[1], (int)cmd[2], cmd[3]);
				}
				if (cmd[1].equalsIgnoreCase("le")) {
					// sistema leArquivo(cmd[1], (int)cmd[2], cmd[3]);
				}
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			Logger.log("Erro na abertura do arquivo: %s.\n" + e.getMessage());
		}
	}

	public void readCmd(String narq) {
		read(narq);
	}

	private void write(String msg) {

		/*
		 * Para escrever no arquivo, tem que ler as mensagens já existentes
		 * e adicionar a nova mensagem a esta lista. Após, tem que escrever
		 * todas as mensagens novamente.
		 */

		try {
			FileReader arq = new FileReader("Log.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			LinkedList<String> linhas = new LinkedList<String>();
			while (linha != null) {
				linhas.add(linha);
				linha = lerArq.readLine();
			}
			arq.close();
			linhas.add(msg);
			FileWriter arqL = new FileWriter("Log.txt");
			PrintWriter buffWrite = new PrintWriter(new FileWriter(
					"Log.txt"));
			for(String s: linhas){
				buffWrite.println(s);
			}
			buffWrite.close();
			arqL.close();
			
			
		} catch (IOException e) {
			Logger.log("Erro na abertura do arquivo: \n" + e.getMessage());
			try {
				new java.io.File("Log.txt").createNewFile();
			} catch (IOException e1) {
				System.out.println("O arquivo não pode ser criado");
				e1.printStackTrace();
			}
			write(msg);
		}

	}

	public void writeLog(String msg) {
		write(msg);
	}
}
