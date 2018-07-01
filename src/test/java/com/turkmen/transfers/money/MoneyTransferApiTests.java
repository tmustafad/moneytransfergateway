/**
 * 
 */
package com.turkmen.transfers.money;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author TTTDEMIRCI
 *
 */
public class MoneyTransferApiTests {

	@BeforeClass
	public static void runFirstbeforeAlltests() {
		StartMoneyTransferApp.loadData();
		StartMoneyTransferApp.startServer();
	}

	@Test
	public void testGetCustomersStatusCode() throws ClientProtocolException, IOException {

		HttpUriRequest request = new HttpGet("http://localhost:7777/transferGateway/getAllCustomers");

		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		assertEquals(200, httpResponse.getStatusLine().getStatusCode());
	}

	@Test
	public void testGetCustomersReturnMediaType() throws ClientProtocolException, IOException {
		String mimeType = "application/json";
		HttpUriRequest request = new HttpGet("http://localhost:7777/transferGateway/getAllCustomers");

		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		String returnMimeType = ContentType.getOrDefault(httpResponse.getEntity()).getMimeType();
		
		assertEquals(mimeType, returnMimeType);
	}
	
	
	
	@Test
	public void testGetCustomersResponseCorrectnes() throws ClientProtocolException, IOException {
		String mimeType = "application/json";
		HttpUriRequest request = new HttpGet("http://localhost:7777/transferGateway/getAllCustomers");

		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		String returnMimeType = ContentType.getOrDefault(httpResponse.getEntity()).getMimeType();
		
		assertEquals(mimeType, returnMimeType);
	}

}
