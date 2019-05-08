package com.qa.Client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;


import com.qa.TestBase.TestBase;

public class RestClient extends TestBase {

	public RestClient(){
		client = HttpClientBuilder.create().build();
	}

	public CloseableHttpResponse getRequestWithHeaders(Map<String, String> headers)
			throws ClientProtocolException, IOException, URISyntaxException {

		
		URIBuilder builder = new URIBuilder();
		builder.setScheme("https").setHost("uat-api.morrisons.com/basket/v2/events")
				.setParameter("eventid[since]", "1534193297768").setParameter("limit", "5")
				.setParameter("eventtype", "create").setParameter("organisation", "FOL")
				.setParameter("apikey", "MtAVprVKna2yvV3BbiW4DQNr1Xn9X6BE");
		URI uri = builder.build();
		HttpGet get = new HttpGet(uri);
		System.out.println(get.getURI());

		for (Entry<String, String> entry : headers.entrySet()) {
			get.addHeader(entry.getKey(), entry.getValue());
		}

		response = client.execute(get);
		return response;
	}
	
	public CloseableHttpResponse optionsRequest() throws ClientProtocolException, IOException{
		HttpOptions options= new HttpOptions("https://uat-api.morrisons.com/basket/v2/events?"
				+ "eventid[since]=1534193297768&limit=5&eventtype=create&organisation=FOL&apikey=MtAVprVKna2yvV3BbiW4DQNr1Xn9X6BE");
		response = client.execute(options);
		return response;
		
	}
	
public CloseableHttpResponse deleteRequestTest() throws ClientProtocolException, IOException{
		
		HttpDelete httpDelete = new HttpDelete("https://uat-api.morrisons.com/basket/v2/events?"
				+ "eventid[since]=1534193297768&limit=5&eventtype=create&organisation=FOL&apikey=MtAVprVKna2yvV3BbiW4DQNr1Xn9X6BE");
		response = client.execute(httpDelete);
		return response;
	}


public CloseableHttpResponse postRequestTest(Map<String, String> headers,String payLoad) throws URISyntaxException, ClientProtocolException, IOException{
	URIBuilder builder = new URIBuilder();
	builder.setScheme("https").setHost("uat-api.morrisons.com/basket/v2/baskets/@finalise")
			.setParameter("apikey", "MtAVprVKna2yvV3BbiW4DQNr1Xn9X6BE");
	URI uri = builder.build();
	HttpPost post = new HttpPost(uri);
	System.out.println(post.getURI());
	post.setEntity(new StringEntity(payLoad, ContentType.APPLICATION_JSON));
	for (Entry<String, String> entry : headers.entrySet()) {
		post.addHeader(entry.getKey(), entry.getValue());
	}
	response = client.execute(post);
	return response;
	
}
}
