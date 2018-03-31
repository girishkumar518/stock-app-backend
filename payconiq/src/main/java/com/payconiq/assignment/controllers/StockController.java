package com.payconiq.assignment.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payconiq.assignment.domain.Stock;
import com.payconiq.assignment.exceptions.InvalidFormatException;
import com.payconiq.assignment.exceptions.StockNotFoundException;
import com.payconiq.assignment.services.StockService;

/**
 * 
 */

/**
 * @author Girish Kumar Chellangi
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class StockController {

	private final Logger LOG = LoggerFactory.getLogger(StockController.class);

	@Autowired
	private StockService stockService;

	@RequestMapping(method = RequestMethod.GET, value = "/stocks")
	public List<Stock> getAllStocks() {
		LOG.debug("Starting getAllStocks ");
		return stockService.getAllStocks();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/stocks/{id}")
	public Stock getStock(@PathVariable Integer id) {
		LOG.debug("Starting getStock ");
		try {
			return stockService.getStock(id);
		} catch (Exception e) {
			LOG.error("Exception occured while fetching stock " + e.getMessage());
			throw new StockNotFoundException("No stock found" + e);
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "/stocks")
	public Stock addStock(@RequestBody Stock stock) {
		LOG.debug("Starting addStock ");
		try {
			return stockService.addStock(stock);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.error("Exception occured "+e.getMessage());
			throw new InvalidFormatException("Invalid format received");
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/stocks/{id}")
	public ResponseEntity<?> modifyStock(@PathVariable Integer id, @RequestBody Stock stock) {
		LOG.debug("Starting modifyStock ");
		return new ResponseEntity<Stock>(stockService.updateStock(id, stock), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/stocks/{id}")
	public boolean deleteStock(@PathVariable Integer id) {
		LOG.debug("Starting deleteStock ");
		return stockService.deleteStock(id);
	}

}
