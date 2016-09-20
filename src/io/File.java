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
import io.Sistema;

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

			if (linha == null) {
				Logger.log("Erro: Arquivo de configuração vazio ou nulo");
				return;
			}

			String cmd[] = linha.split(" ");
			Sistema so = new Sistema(Integer.parseInt(cmd[0]),
					Integer.parseInt(cmd[1]));
			linha = lerArq.readLine();
			while (linha != null) {
				cmd = linha.split(" ");

				if (cmd[0].equalsIgnoreCase("criar"))
					so.criarArquivo(cmd[1], Integer.parseInt(cmd[2]));

				if (cmd[0].equalsIgnoreCase("destroi"))
					so.destroiArquivo(cmd[1]);

				if (cmd[0].equalsIgnoreCase("varre"))
					so.varreArquivo(cmd[1]);

				if (cmd[0].equalsIgnoreCase("escreve")) {
					String texto = "";
					for (int i = 3; i < cmd.length; i++)
						texto += cmd[i] + " ";
					so.escreveArquivo(cmd[1], Integer.parseInt(cmd[2]), texto);
				}
				if (cmd[0].equalsIgnoreCase("le"))
					so.leArquivo(cmd[1], Integer.parseInt(cmd[2]),
							Integer.parseInt(cmd[3]));
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			Logger.log("Erro na abertura do arquivo: Config.txt"
					+ e.getMessage());
			try {
				new java.io.File("Config.txt").createNewFile();
			} catch (IOException e1) {
				System.out.println("O arquivo não pode ser criado");
				e1.printStackTrace();
			}
		}
	}

	public void readCmd(String narq) {
		read(narq);
	}

	private void write(String msg) {

		/*
		 * Para escrever no arquivo, tem que ler as mensagens já existentes e
		 * adicionar a nova mensagem a esta lista. Após, tem que escrever todas
		 * as mensagens novamente.
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
			PrintWriter buffWrite = new PrintWriter(new FileWriter("Log.txt"));
			for (String s : linhas) {
				buffWrite.println(s);
			}
			buffWrite.close();
			arqL.close();

		} catch (IOException e) {
			Logger.log("Erro na abertura do arquivo: Log.txt" + e.getMessage());
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
