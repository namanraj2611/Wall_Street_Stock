package com.cts.ss.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//import com.example.exception.DepartmentException;
import com.cts.ss.model.Stock;
import com.cts.ss.repository.StockRepository;


@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository repository;

	@Override
	public List<Stock> getStocks() {
		
		return repository.findAll();
	}
	
	@Override
	public Stock saveStock(Stock stock) {
		return repository.save(stock);
	}

//	@Override
//	public Stock getStockById(String id) {
//		Stock s = repository.findById(id);
//		return e;
//		
//	}

}
