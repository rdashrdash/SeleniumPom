package com.naukri.qa.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LoggingConsole {

	private static final Logger log = LogManager.getLogger(LoggingConsole.class.getName());

	public static void main(String[] args) {
		log.debug("Debug message loaded");
		log.error("Error message loaded");
	}
}
