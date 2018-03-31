/**
 * 
 */
package com.payconiq.assignment.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;

/**
 * @author Girish kUmar CHellangi
 *
 */
public class StockError {

	private HttpStatus status;

	private Date timestamp;
	private String message;
	private String details;

	public StockError(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;

	}

	@Override
	public String toString() {
		return "StockError [status=" + status + ", timestamp=" + timestamp + ", message=" + message + ", details="
				+ details + "]";
	}
	
	
}
