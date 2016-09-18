package io;

import java.io.IOException;
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
	
	public static void log(String mensagem){
	File writer = new File();	
		/* Escrever no arquivo log.txt */
		
		/* */
		
		/* Imprime mensagem no terminal */
		System.out.println(new Date() +" : "+ mensagem);
		String log = new Date() + " : "+ mensagem;
		writer.writeLog(log);
	}

}
