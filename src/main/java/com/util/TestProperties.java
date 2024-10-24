package com.util;

import java.io.FileInputStream;
//import java.io.FileInputStream.*;
import java.io.IOException;
import java.util.Properties;

import com.context.Constants;

public class TestProperties {

	private static final Properties props = new Properties();

	public static void loadAllPropertie() {
		try {
			FileInputStream Locator;
			Locator = new FileInputStream(Constants.PROPERTY_FILE_PATH);
			props.load(Locator);
		} catch (IOException e) {
			LoggerUtil.getLogger().fatal("Could not load properties : " + e.getMessage());
		}
	}

	public static String getProperty(String key) {
		return props.getProperty(key);
	}

	public static void putProperty(String key, String value) {
		props.put(key, value);
	}

	public static void setProperty(String key, String value) {
		props.setProperty(key, value);
	}
}