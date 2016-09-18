package io;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class File {
	public void readCmd(File narq){
		Scanner ler = new Scanner(System.in);
		System.out.printf("Informe o nome de arquivo texto:\n");
		String nome = ler.nextLine();
 
		System.out.printf("\nConteúdo do arquivo texto:\n");
		try {
			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine(); 
			while (linha != null) {
				System.out.printf("%s\n", linha);
				linha = lerArq.readLine(); 
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
				
				
			}
 
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
			e.getMessage());
		}
	}
}
