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
		for (int i = pos, j = 0; i < caracteres.length && j < s.length(); i++, j++) {
			caracteres[i] = s.charAt(j);
		}
	}

	String getCaracteres() {
		return new String(caracteres);
	}
	
	int getTamanho() {
		return caracteres.length;
	}

}
