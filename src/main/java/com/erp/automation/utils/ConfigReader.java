package com.erp.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	   private static Properties prop;

	    public static void loadProperties() {
	        if (prop == null) {
	            prop = new Properties();
	            try {
	                FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
	                prop.load(fis);
	            } catch (IOException e) {
	                e.printStackTrace();
	                throw new RuntimeException("Failed to load config file.");
	            }
	        }
	    }

	    public static String get(String key) {
	        if (prop == null) {
	            loadProperties();
	        }
	        return prop.getProperty(key);
	    }
	
	
}
