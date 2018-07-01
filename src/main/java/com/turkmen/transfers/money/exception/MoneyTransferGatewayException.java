/**
 * 
 */
package com.turkmen.transfers.money.exception;

/**
 * @author TTTDEMIRCI
 *
 */
public class MoneyTransferGatewayException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MoneyTransferGatewayException(String message) {
		super(message);
	}
	
	public MoneyTransferGatewayException(String message,Throwable cause) {
		super(message,cause);
	}
}
