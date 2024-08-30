package com.mystore.utilities;


import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ReadConfig {

	static Properties properties;
	String path = "C:\\Users\\admin\\eclipse-workspace\\DemoProject\\src\\Screenshot\\Project\\Configuration\\config.properties";
	
	public ReadConfig()
	{
		try {

			properties = new Properties(); // initialize object properties (created on line no. 8)
			
			FileInputStream fis =new FileInputStream(path);
			properties.load(fis);
			
		} catch (FileNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		//to read base url value
		public static String getBaseUrl()
		{
			String value = properties.getProperty("baseUrl");
			
			if(value!=null)
				return value;
			else
				throw new RuntimeException("url not specified in config file.");
			
		}
		public String getBrowser()
		{
			String value = properties.getProperty("browser");
			
			if(value!=null)
				return value;
			else
				throw new RuntimeException("url not specified in config file.");
			
		}
		
	
		public String getEmail()
		{
			String email = properties.getProperty("email");
			if(email!=null)
				return email;
			else
				throw new RuntimeException("email not specified in config file.");
			
		}

		public String getPassword()
		{
			String password = properties.getProperty("password");
			if(password!=null)
				return password;
			else
				throw new RuntimeException("password not specified in config file.");
			
		}
	
		
	}

