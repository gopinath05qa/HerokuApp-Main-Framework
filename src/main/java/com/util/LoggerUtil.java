package com.util;

import org.apache.log4j.Logger;

import com.listeners.LogListener;

public class LoggerUtil {

	private static Logger logger = Logger.getLogger(LogListener.class);

	public static void info(String message) {
		logger.info(message);
	}

	public static void debug(String message) {
		logger.debug(message);
	}

	public static void error(String message) {
		logger.error(message);
	}

	public static Logger getLogger() {
		return logger;
	}
}
