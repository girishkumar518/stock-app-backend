/**
 * 
 */
package com.payconiq.assignment.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payconiq.assignment.dao.StockRepository;
import com.payconiq.assignment.domain.Stock;
import com.payconiq.assignment.exceptions.StockNotFoundException;

/**
 * @author Girish Kumar Chellangi
 *
 */
@Service
public class StockService {

	private final Logger LOG = LoggerFactory.getLogger(StockService.class);
	// private List<Stock> stockList;

	@Autowired
	private StockRepository repo;

	//
	// public StockService() {
	//
	// stockList = new ArrayList<>();
	// stockList.add(new Stock(1,"Byteridge",15.5,1.0,1.0));
	// stockList.add(new Stock(2,"Polaris",15.5,1.0,1.0));
	// stockList.add(new Stock(3,"TCS",15.5,1.0,1.0));
	// stockList.add(new Stock(4,"Wellsfargo",15.5,1.0,1.0));
	// stockList.add(new Stock(5,"NCR",15.5,1.0,1.0));
	//
	// }

	public List<Stock> getAllStocks() {
		return repo.findAll();
	}

	public Stock getStock(Integer id) {
		// return stockList.stream().filter(i->i.getId().equals(id)).findFirst().get();
		LOG.debug("getStock started !!!");
		return repo.findById(id).orElseThrow(() -> new StockNotFoundException("Stock Not Found " + id) );
	}

	public Stock addStock(Stock stock) throws Exception{
		// stock.setId(stockList.size()+1);
		// return stockList.add(stock);
		return repo.save(stock);
	}

	public Stock updateStock(Integer id, Stock stock) {

		// LOG.debug("In updateStock ");
		//
		// Stock temp =
		// stockList.stream().filter(i->i.getId().equals(id)).findFirst().get();
		// temp.update(stock);
		//
		// LOG.debug("Stock updated ");
		//
		// return temp;
		
		LOG.debug("update Stock Started ");

		Stock temp = repo.findById(id).orElseThrow(() -> new StockNotFoundException("Stock not found :" + id));

		temp.update(stock);
		Stock updatedNote = repo.save(temp);
		
		LOG.debug("update Stock updated ");
		return updatedNote;
	}

	public boolean deleteStock(Integer id) {
		// return
		// stockList.remove(stockList.stream().filter(i->i.getId().equals(id)).findFirst().get());
		// return repo.deleteById(id);
		LOG.debug("delete Stock Started ");
		Stock temp = repo.findById(id).orElseThrow(() -> new StockNotFoundException("Stock not found :" + id));
		repo.delete(temp);
		LOG.debug(" Stock Deleted ");
		
		return true ;
	}

}
