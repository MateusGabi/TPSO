package models;

import java.util.LinkedList;

/**
 * 
 * @author Mateus Gabi
 *
 */
public class BlocoLivre implements Bloco {

	/**
	 * Fila dos blocos livres
	 */
	private int[] indicesLivres;

	BlocoLivre(int numeroDeEntradas) {

		indicesLivres = new int[numeroDeEntradas];

		/* O bloco 0 est� ocupado, � o diret�rio */
		indicesLivres[0] = 1;

		/* O bloco 1 est� ocupado, � o pr�prio bloco livres */
		indicesLivres[1] = 1;

		/* Setamos o resto com -1. Item (i) da especifica��o do trabalho */
		for (int i = 2; i < numeroDeEntradas; i++) {
			indicesLivres[i] = -1;
		}

	}

	/**
	 * 
	 * @return o �ndice dispon�vel, ou -1 em caso estar cheio.
	 */
	public int getProximoDisponivel() {
		int i = 0;
		while (indicesLivres[i++] != -1) {
			if (i == indicesLivres.length) {
				i = 0;
				break;
			}
		}

		return i - 1;
	}

	/**
	 * Recebe uma lista de indices para serem setados como ocupado (n�o livres)
	 * 
	 * @param indicesDosBlocosDeDadosReservados
	 */
	public void setIndicesComoOcupados(
			LinkedList<Integer> indicesDosBlocosDeDadosReservados) {

		for (Integer indice : indicesDosBlocosDeDadosReservados) {
			indicesLivres[indice] = 1;
		}

	}

	/**
	 * Retorna todos os indices livres
	 * @return
	 */
	public LinkedList<Integer> getIndicesLivres() {

		LinkedList<Integer> l = new LinkedList<Integer>();

		for (int i = 0; i < indicesLivres.length; i++) {

			/* os campos setados com -1 s�o livre */
			if (indicesLivres[i] < 0) {
				l.add(i);
			}

		}

		return l;

	}

}
