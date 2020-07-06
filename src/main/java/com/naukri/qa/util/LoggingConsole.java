package com.naukri.qa.util;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LoggingConsole {

	static Logger log = Logger.getLogger(LoggingConsole.class.getName());

	public static void main(String[] args) {
		BasicConfigurator.configure();
		
		log.debug("Debug message loaded");
		log.error("Error message loaded");
	}
}
