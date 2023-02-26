package com.cts.ss.service;

import java.util.List;

//import com.example.exception.DepartmentException;
import com.cts.ss.model.Stock;

public interface StockService {

	List<Stock> getStocks();
	public Stock saveStock(Stock stock);
	//Stock getStockById(String id);
}