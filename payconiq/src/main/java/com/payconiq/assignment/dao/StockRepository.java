package com.payconiq.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payconiq.assignment.domain.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock,Integer>{
	
}
