/**
 * 
 */
package com.turkmen.transfers.money;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.turkmen.transfers.money.model.Account;
import com.turkmen.transfers.money.model.Customer;

/**
 * @author TTTDEMIRCI
 *
 */
public class MoneyTransferApiTests {

	private static String URI_GETALLCUSTOMERS = "http://localhost:7777/transferGateway/getAllCustomers";
	private static String URI_GETALLACCOUNTS = "http://localhost:7777/transferGateway/getAllAccounts";
	private static String URI_POST_CREATECUSTOMER = "http://localhost:7777/transferGateway/createCustomer";
	private static String URI_POST_CREATEACCOUNT = "http://localhost:7777/transferGateway/createAccount";
	

	@BeforeClass
	public static void runFirstbeforeAlltests() {
		StartMoneyTransferApp.loadData("no");//If you want to see the hsqldb viewer ,set this argument to "yes"
		StartMoneyTransferApp.startServer();
	}

	public static <T> T retrieveResourceFromResponse(HttpResponse response, Class<T> clazz) throws IOException {

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(jsonFromResponse, clazz);
	}

	public String getCreateCustomerPayload() {
		String payload = "{" + "\"name\": \"TOM\", " + "\"surname\": \"JACKSON\", " + "\"accounts\":[]"
				+ "}";
		return payload;
	}
	
	
	public String getCreateAccountPayload() {
		String payload = "{" + "\"customer\": {\"id\":1},\"type\":\"CHECKING\",\"balance\":\"4000\""
				+ "}";
		return payload;
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

		assertThat(customers, hasSize(1));

	}

	@Test
	public void testGetAccountsStatusCode() throws ClientProtocolException, IOException {

		HttpUriRequest request = new HttpGet(URI_GETALLACCOUNTS);

		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		assertEquals(200, httpResponse.getStatusLine().getStatusCode());
	}

	@Test
	public void testGetAccountsReturnMediaType() throws ClientProtocolException, IOException {
		String mimeType = "application/json";
		HttpUriRequest request = new HttpGet(URI_GETALLACCOUNTS);

		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		String returnMimeType = ContentType.getOrDefault(httpResponse.getEntity()).getMimeType();

		assertEquals(mimeType, returnMimeType);
	}

	@Test
	public void testGetAccountsResponseSize() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet(URI_GETALLACCOUNTS);

		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		List<Account> accounts = retrieveResourceFromResponse(httpResponse, List.class);

		assertThat(accounts, hasSize(3));

	}

	@Test
	public void testCreateCustomer() throws ClientProtocolException, IOException {

		StringEntity entity = new StringEntity(getCreateCustomerPayload(), ContentType.APPLICATION_JSON);

		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost postRequest = new HttpPost(URI_POST_CREATECUSTOMER);
		postRequest.setEntity(entity);

		HttpResponse response = httpClient.execute(postRequest);

		assertEquals(200, response.getStatusLine().getStatusCode());

	}
	
	
	@Test
	public void testCreateAccount() throws ClientProtocolException, IOException {

		StringEntity entity = new StringEntity(getCreateAccountPayload(), ContentType.APPLICATION_JSON);

		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost postRequest = new HttpPost(URI_POST_CREATEACCOUNT);
		postRequest.setEntity(entity);

		HttpResponse response = httpClient.execute(postRequest);

		assertEquals(200, response.getStatusLine().getStatusCode());

	}
}
