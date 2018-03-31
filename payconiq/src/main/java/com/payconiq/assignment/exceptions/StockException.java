/**
 * 
 */
package com.payconiq.assignment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Girish Kumar Chellangi
 *
 */
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class StockException extends RuntimeException{
	
	public StockException(String exception) {
		super(exception);
	}

}
