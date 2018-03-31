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
@ResponseStatus(HttpStatus.NOT_FOUND)
public class StockNotFoundException extends RuntimeException{
	
	public StockNotFoundException(String exception) {
		super(exception);
	}

}
