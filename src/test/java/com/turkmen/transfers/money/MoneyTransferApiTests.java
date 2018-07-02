/**
 * 
 */
package com.turkmen.transfers.money;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.turkmen.transfers.money.model.Customer;
import static org.hamcrest.Matchers.*;

/**
 * @author TTTDEMIRCI
 *
 */
public class MoneyTransferApiTests {

	private static String URI_GETALLCUSTOMERS = "http://localhost:7777/transferGateway/getAllCustomers";

	@BeforeClass
	public static void runFirstbeforeAlltests() {
		StartMoneyTransferApp.loadData();
		StartMoneyTransferApp.startServer();
	}

	public static <T> T retrieveResourceFromResponse(HttpResponse response, Class<T> clazz) throws IOException {

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(jsonFromResponse, clazz);
	}

	@Test
	public void testGetCustomersStatusCode() throws ClientProtocolException, IOException {

		HttpUriRequest request = new HttpGet(URI_GETALLCUSTOMERS);

		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		assertEquals(200, httpResponse.getStatusLine().getStatusCode());
	}

	@Test
	public void testGetCustomersReturnMediaType() throws ClientProtocolException, IOException {
		String mimeType = "application/json";
		HttpUriRequest request = new HttpGet(URI_GETALLCUSTOMERS);

		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		String returnMimeType = ContentType.getOrDefault(httpResponse.getEntity()).getMimeType();

		assertEquals(mimeType, returnMimeType);
	}

	@Test
	public void testGetCustomersResponseSize() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet(URI_GETALLCUSTOMERS);

		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		
		List<Customer> customers = retrieveResourceFromResponse(httpResponse, List.class);
		
		assertThat(customers,hasSize(1) );

	}

	
	
	
}
