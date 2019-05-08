package com.qa.utils;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseUtils {

	public String getHeaderValue(CloseableHttpResponse response,String headerName){
		
		Header[] headers = response.getAllHeaders();
		String headerValue = null;
		
		for(Header header:headers){
		
			if(headerName.equalsIgnoreCase(header.getName())){
				 headerValue = header.getValue();
				break;
			}	
		}
		return headerValue;
		
	}

	public boolean isHeaderPresent(CloseableHttpResponse response,String headerName){
		
		Header[] headers = response.getAllHeaders();
		boolean flag = false;
		for(Header header:headers){
			if(headerName.equalsIgnoreCase(header.getName()))
				flag = true;
			break;
		}
		return flag;
		
		
		
	}
	
	public <T> T unmarshall(CloseableHttpResponse response,Class <T> clazz) throws ParseException, IOException{
		String jsonBody = EntityUtils.toString((response.getEntity()));
		String trimmedJsonBody = jsonBody.substring(jsonBody.indexOf('{'));
		return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.readValue(trimmedJsonBody, clazz);
	}
	
}
