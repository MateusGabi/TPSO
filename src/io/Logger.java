package io;

import java.util.Date;

import io.File;

/**
 * Um Logger serve para escrever em um arquivo e no terminal os eventos do
 * sistema (Especificação y).
 * 
 * @author Mateus Gabi
 *
 */
public class Logger {

	public static void log(String mensagem) {
		
		String log = new Date() + " : " + mensagem;
		
		/* Escrever no arquivo log.txt */
		 new File().writeLog(log);

		/* Imprime mensagem no terminal */
		System.out.println(log);
	}

}
