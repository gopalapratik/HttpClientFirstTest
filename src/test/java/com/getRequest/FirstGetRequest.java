package com.getRequest;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Users.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FirstGetRequest extends User {

	@Test
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
//		public httpResponse(String ) {
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet("https://uat-api.morrisons.com/basket/v2/events?"
				+ "eventid%5Bsince%5D=1534193297768&limit=5&eventtype=create&organisation=FOL&apikey=MtAVprVKna2yvV3BbiW4DQNr1Xn9X6BE");

		// HttpGet get = new
		// HttpGet("https://uat-api.morrisons.com/basket/v2/baskets/null?apikey=MtAVprVKna2yvV3BbiW4DQNr1Xn9X6BE");
		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		headerMap.put("Authorization", "Basic TXRBVnByVktuYTJ5dlYzQmJpVzREUU5yMVhuOVg2QkU6am5rMmF0UUMyWGlRdEhJWg==");
		headerMap.put("correlationToken", "123123121");
		for (Map.Entry<String, String> entry : headerMap.entrySet()) {
			get.addHeader(entry.getKey(), entry.getValue());
		}

		HttpResponse response = httpclient.execute(get);
		
	

		// 1. Getting Status code
		int responseCode = response.getStatusLine().getStatusCode();
		System.out.println("Response code is " + responseCode);

		// 2. Checking Content Type

		Header contentType = response.getEntity().getContentType();
		System.out.println("Content Type is " + contentType + "\n");

		// 3. Checking one Header value

		String headerValue = getHeader(response, "Connection");

		System.out.println("Header Value is " + headerValue);

		// 4. Check for the presence of Header

		boolean isHeaderPresent = getPresenceOfHeader(response, "Connectionn");
		
		System.out.println("Header Connection is present :  " + isHeaderPresent);
		
		
		//5. Getting the Body of JSON as String
		
		String jsonBody= EntityUtils.toString(response.getEntity());
		System.out.println(jsonBody);
		
		//6.Getting the Body of JSON as Map 
		
		JSONObject jsonObject = new JSONObject(jsonBody.substring(jsonBody.indexOf('{'))); // removing the square bracket as jsonObject text must begin with '{'
		
		System.out.println(jsonObject);
		
		
		Object valueOFEventID = getValueFor(jsonObject,"eventId");
		System.out.println(valueOFEventID);
		
		//7.Using Jackson
		
		
	User user = unmarshall(response,User.class);
		
	Assert.assertEquals(user.getEventId(), "1554886470784");
		
	}



	










	private static String getHeader(HttpResponse response, String headerName) {
		/*
		 * 1. Get all headers 2. Loop over the Header list 3. If no header found
		 * - throw an exception 4. Return the header
		 */

		Header[] headers = response.getAllHeaders();
		List<Header> httpHeaders = Arrays.asList(headers);
		String returnHeader = "";
		for (Header header : httpHeaders) {
			if (headerName.equalsIgnoreCase(header.getName())) {
				returnHeader = header.getValue();
				// System.out.println(header.getName() + header.getValue());
			}
		}
		if (returnHeader.isEmpty()) {
			throw new RuntimeErrorException(null, "Did not find header " + headerName);
		}
		return returnHeader;

	}

	private static boolean getPresenceOfHeader(HttpResponse response, String headerName) {

		Header[] allHeaders = response.getAllHeaders();
		List<Header> listHeader = Arrays.asList(allHeaders);
		boolean flag = false;
		for (Header header : listHeader) {
			if (header.getName().equalsIgnoreCase(headerName))
				flag = true;
		}
		return flag;

	}
	
	private static Object getValueFor(JSONObject jsonobject, String key) {
		return jsonobject.get(key);
	}
	
	@SuppressWarnings("unused")
	public static User unmarshall(HttpResponse response, Class<User> clazz) throws ParseException, IOException {
		
		String jsonBody = EntityUtils.toString(response.getEntity());
		
		 ObjectMapper mapper = new ObjectMapper();
	
		 
//		 @SuppressWarnings("deprecation")
//		List<User> users = mapper.reader()
//			      .withType(new TypeReference<List<User>>() {})
//			      .readValue(jsonBody);
//		 
		return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.readValue(jsonBody, clazz);
		
		
	}
	
	

}
