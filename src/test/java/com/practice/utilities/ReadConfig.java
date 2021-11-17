package com.practice.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	public static Properties prop;
	
	public static void Readconfig() {
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception while loading Config file"+e.getMessage());
		}
	}
	
	public static String getBrowser() {
		Readconfig();
		String browser = prop.getProperty("browser");
		return browser;
	}
	
	public static String getUrl() {
		Readconfig();
		String url = prop.getProperty("url");
		return url;
				
	}
}


