package models;

/**
 * 
 * @author Mateus Gabi
 *
 */
public class BlocoDados implements Bloco {

	private char[] caracteres;

	BlocoDados(int tamanho) {
		caracteres = new char[tamanho];
	}
	
	void setCaracteres(String s, int pos){
		for (int i = pos; i < caracteres.length && i < s.length(); i++) {
			caracteres[i] = s.charAt(i);
		}
	}

	String getCaracteres() {
		return new String(caracteres);
	}

}
