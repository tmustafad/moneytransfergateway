package com.turkmen.transfers.money;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.hsqldb.util.DatabaseManagerSwing;

import com.sun.net.httpserver.HttpServer;
import com.turkmen.transfers.money.controller.MainController;
import com.turkmen.transfers.money.util.MoneyTransferGatewayUtils;

/**
 * Hello world!
 *
 */
public class StartMoneyTransferApp {

	public static HttpServer startServer() {
		URI mainUri = UriBuilder.fromUri(MoneyTransferGatewayUtils.HOST).port(MoneyTransferGatewayUtils.PORT).build();

		ResourceConfig resourceConfig = new ResourceConfig(MainController.class);

		HttpServer server = JdkHttpServerFactory.createHttpServer(mainUri, resourceConfig);
		return server;
	}

	public static void loadData() {
		MoneyTransferGatewayUtils.loadSampleData();
		DatabaseManagerSwing.main(
				new String[] { "--url", "jdbc:hsqldb:mem:moneyTransferGateway", "--user", "sa", "--password", "" });
	}

	public static void main(String[] args) {

		loadData();

		startServer();

	}
}
