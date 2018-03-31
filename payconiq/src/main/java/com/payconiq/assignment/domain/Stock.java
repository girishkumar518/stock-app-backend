/**
 * 
 */
package com.payconiq.assignment.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.LastModifiedDate;

/**
 * @author Girish Kumar Chellangi
 *
 */
@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String name;
	
	//@NotNull
	private Double currentPrice;
	
	@Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
	private Date lastUpdate;
	
	private Double highPrice;
	private Double lowPrice;
	private Double faceValue;
	private Double bookValue;

	/**
	 * @param id
	 * @param name
	 * @param currentPrice
	 * @param faceValue
	 * @param bookValue
	 */
	
	public Stock() {
		
	}
	
	public Stock(int id,String name, Double currentPrice, Double faceValue, Double bookValue) {
		super();
		this.id=id;
		this.name = name;
		this.currentPrice = currentPrice;
		this.highPrice = currentPrice;
		this.lowPrice = currentPrice;
		this.faceValue = faceValue;
		this.bookValue = bookValue;
		this.lastUpdate = new Date(System.currentTimeMillis());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice) {

		this.setHighPrice(currentPrice);
		this.setLowPrice(currentPrice);

		this.currentPrice = currentPrice;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Double getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(Double faceValue) {
		this.faceValue = faceValue;
	}

	public Double getBookValue() {
		return bookValue;
	}

	public void setBookValue(Double bookValue) {
		this.bookValue = bookValue;
	}

	public Double getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(Double highPrice) {
		this.highPrice = highPrice;
	}

	public Double getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(Double lowPrice) {
		this.lowPrice = lowPrice;
	}
	
	public void update(Stock stock) {
		
		this.name = stock.name;
		this.currentPrice = stock.currentPrice;
		if(stock.currentPrice > this.highPrice)
			this.highPrice = currentPrice;
		if(stock.currentPrice < this.lowPrice)
			this.lowPrice = currentPrice;
		this.faceValue = stock.faceValue;
		this.bookValue = stock.bookValue;
		this.lastUpdate = new Date(System.currentTimeMillis());
		
	}

}
