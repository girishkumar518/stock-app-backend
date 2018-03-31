package com.payconiq.assignment.exceptions;

import java.nio.file.AccessDeniedException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class StockResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(StockNotFoundException.class)
	public final ResponseEntity<StockError> handleUserNotFoundException(StockNotFoundException ex, WebRequest request) {
		StockError errorDetails = new StockError(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidFormatException.class)
	public final ResponseEntity<StockError> handleAllExceptions(InvalidFormatException ex, WebRequest request) {
		StockError errorDetails = new StockError(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<StockError> handleAllExceptions(Exception ex, WebRequest request) {
		StockError errorDetails = new StockError(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ AccessDeniedException.class })
	public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
		StockError errorDetails = new StockError(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
	}
}