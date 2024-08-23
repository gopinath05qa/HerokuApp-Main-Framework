package com.util;

import org.apache.log4j.Logger;

import com.listeners.LogListener;

/**
 * The Class has all Logging related utilities.
 *
 * @author Omprakash darsi
 */
public class LoggerUtil {

	/** The logger. */
	private static Logger logger = Logger.getLogger(LogListener.class);

	/**
	 * Log.
	 *
	 * @param message the message
	 */
	public static void info(String message) {
		logger.info(message);
	}

	public static void debug(String message) {
		logger.debug(message);
	}
	
	public static void error(String message) {
		logger.error(message);
	}
	/**
	 * Gets the logger.
	 *
	 * @return the logger
	 */
	public static Logger getLogger() {
		return logger;
	}
}
