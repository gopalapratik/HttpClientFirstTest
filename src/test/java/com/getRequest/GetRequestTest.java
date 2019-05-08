package com.getRequest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import com.Users.Event;
import com.Users.EventData;
import com.qa.Client.RestClient;
import com.qa.TestBase.TestBase;
import com.qa.utils.ResponseUtils;

public class GetRequestTest extends TestBase {
	RestClient restClient;
	ResponseUtils resposeutils;

	// @Test
	public void getRequestTestWithHeaders() throws ClientProtocolException, IOException, URISyntaxException {
		restClient = new RestClient();
		resposeutils = new ResponseUtils();
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", "Basic TXRBVnByVktuYTJ5dlYzQmJpVzREUU5yMVhuOVg2QkU6am5rMmF0UUMyWGlRdEhJWg==");
		headers.put("correlationToken", "123123121");
		response = restClient.getRequestWithHeaders(headers);
		// 1. Getting all the headers through response
		System.out.println("Response is " + response);
		int statusCode = response.getStatusLine().getStatusCode();
		// 2. Getting the statuscode
		System.out.println("StatusCode is " + statusCode);
		// 3. Getting the Content-Type
		Header contentType = response.getEntity().getContentType();
		System.out.println("ContentType is " + contentType.getValue());
		// 4 Getting any Header - Generic
		String headerValue = resposeutils.getHeaderValue(response, "Transfer-Encoding");
		System.out.println("The value for Header is " + headerValue);
		// 5. Verify if Header is present or not
		boolean isHeaderPresent = resposeutils.isHeaderPresent(response, "Date");
		System.out.println("Header is Preesent(true/false): " + isHeaderPresent);
		// 6. Getting the Body of JSON - JSONBody
		// String jsonBody = EntityUtils.toString((response.getEntity()));
		// System.out.println("JsonBody is "+ jsonBody);
		// 7.Getting the Body of JSON as Map

		// JSONObject jsonObject = new
		// JSONObject(jsonBody.substring(jsonBody.indexOf('{'))); // removing
		// the square bracket as jsonObject text must begin with '{'
		// System.out.println(jsonObject);

		// 8. UnMarshalling - Convert JSON to Java Object and UnMarshall Nested
		Event event = resposeutils.unmarshall(response, Event.class);
		System.out.println("Using Jackson Value of getValue is " + event.getEventData().getHeader().getCheckoutDate());

	}

	// @Test
	public void optionsRequestTest() throws ClientProtocolException, IOException {

		String header = "Access-Control-Allow-Methods";
		restClient = new RestClient();
		resposeutils = new ResponseUtils();
		response = restClient.optionsRequest();
		String whatOptionsAvailable = resposeutils.getHeaderValue(response, header);
		System.out.println(whatOptionsAvailable);

	}

	// @Test
	public void deleteRequestTest() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		response = restClient.deleteRequestTest();
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
	}

	@Test
	public void postRequestTest() throws ClientProtocolException, IOException, URISyntaxException {
		String json = "{\r\n  \"departmentSales\": null,\r\n  \"header\": {\r\n    \"transactionId\": 334455,\r\n    \"organisation\": \"FOL\",\r\n    \"basketTotal\": 207.220000,\r\n    \"cashier\": \"1\",\r\n    \"checkoutDate\": \"2016-10-12T09:03:45.999Z\",\r\n    \"cardNumber\": \"9826135802020575193\",\r\n    \"accountId\": \"8765\",\r\n    \"country\": \"GBR\",\r\n    \"countryDescription\": \"Great Britain\",\r\n    \"currency\": \"GBP\",\r\n    \"isTraining\": false,\r\n    \"outputProhibited\": false,\r\n    \"receiptNumber\": \"123-4321\",\r\n    \"storeId\": 9936,\r\n    \"storeName\": null,\r\n    \"tillNumber\": 1,\r\n    \"refundFlag\": false\r\n  },\r\n  \"items\": {\r\n    \"basketItem\": [{\r\n      \"barcode\": \"61292\",\r\n      \"barcodeQuantity\": 1.000000,\r\n      \"department\": 319,\r\n      \"priceChangeType\": null,\r\n      \"quantity\": 1.000000,\r\n      \"quantityType\": null,\r\n      \"storePrice\": 15.000000,\r\n      \"unitPrice\": 15.000000\r\n    }, {\r\n      \"barcode\": \"0\",\r\n      \"barcodeQuantity\": 1.000000,\r\n      \"department\": 9970,\r\n      \"priceChangeType\": null,\r\n      \"quantity\": 1.000000,\r\n      \"quantityType\": null,\r\n      \"storePrice\": 50.000000,\r\n      \"unitPrice\": 50.000000\r\n    }]\r\n  },\r\n  \"tenderedCoupons\": [{\r\n    \"coupon\": [{\r\n      \"qualifyingItems\": {\r\n        \"item\": [\r\n          {\r\n            \"barcode\": \"123456\",\r\n            \"linkType\": null\r\n          }\r\n        ]\r\n      },\r\n      \"number\": \"9927410014404\",\r\n      \"rewardType\": \"MoneyOffProduct\",\r\n      \"pointsType\": null,\r\n      \"rewardAmount\": 1\r\n    }, {\r\n      \"qualifyingItems\": null,\r\n      \"number\": \"9927410010839\",\r\n      \"rewardType\": \"FreeDelivery\",\r\n      \"pointsType\": null,\r\n      \"rewardAmount\": 5\r\n    }, {\r\n      \"qualifyingItems\": null,\r\n      \"number\": \"9927410010855\",\r\n      \"rewardType\": \"GetPercentOff\",\r\n      \"pointsType\": null,\r\n      \"rewardAmount\": 10\r\n    }]\r\n  }, {\r\n    \"coupon\": []\r\n  }],\r\n  \"triggeredPromotions\": {\r\n    \"promotion\": []\r\n  },\r\n  \"triggeredConflicts\": [],\r\n  \"calculatedRewards\": null\r\n}";
		restClient = new RestClient();
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", "Basic TXRBVnByVktuYTJ5dlYzQmJpVzREUU5yMVhuOVg2QkU6am5rMmF0UUMyWGlRdEhJWg==");
		response = restClient.postRequestTest(headers, json);
		String jsonBody = EntityUtils.toString((response.getEntity()));
		 System.out.println("JsonBody is "+ jsonBody);
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		
	}

}
