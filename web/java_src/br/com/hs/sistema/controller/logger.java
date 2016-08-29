package br.com.hs.sistema.controller;

import org.apache.log4j.Logger;

public class logger {
	
	public static void info(String msg){
		Logger logger = Logger.getLogger("R");
		logger.info(msg);
	}
	public static void debug(String msg){
		Logger logger = Logger.getLogger("R");
		logger.debug(msg);
	}
	public static void error(String msg){
		Logger logger = Logger.getLogger("R");
		logger.error(msg);
	}
}
