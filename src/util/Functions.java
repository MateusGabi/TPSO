package util;

public class Functions {
	
	public static String formatarStringNomeDoArquivo(String nome) {
		
		if (nome.length() > 8) {
			
			return nome.substring(0, 8);
			
			
		}
		
		return nome;
	}
}
