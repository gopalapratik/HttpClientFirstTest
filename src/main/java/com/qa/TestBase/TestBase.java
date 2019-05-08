package com.qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.impl.client.CloseableHttpClient;

import com.Users.EventData;

public class TestBase {
	
	public Properties prop;
	public FileInputStream ip;
	public CloseableHttpClient client;
	public CloseableHttpResponse response;

	
	
	public TestBase(){
		prop = new Properties();
		try {
			ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\qa\\utils\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
