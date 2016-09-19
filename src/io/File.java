package io;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File {
	private void read(String narq){
		Logger.log("Arquivo de CMD sendo lido");
		String nome = narq;
		try {
			/* 
			 * arq = Variavel que recebe o arquivo a ser lido;
			 * Enquanto tiver comandos a serem lidos o arquivo vai ser
			 * lido!
			 * 
			 * @author Pedro Henrique
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
			Logger.log("Erro na abertura do arquivo: %s.\n" +
			e.getMessage());
		}		
	}
	public void readCmd(String narq){
		read(narq);
	}
	private void write(String msg){
		
		try{
			FileReader arq = new FileReader("Log.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			while(linha != null){
				linha = lerArq.readLine();
			}
			if(linha == null){
				BufferedWriter buffWrite = new BufferedWriter(new FileWriter("Log.txt"));
				linha = msg;
				buffWrite.append(linha);
	        	buffWrite.close();
			}
		}
		catch(IOException e){
			Logger.log("Erro na abertura do arquivo: %s.\n" +
			e.getMessage());
		}
	}
	public void writeLog(String msg){
		write(msg);
	}
}
