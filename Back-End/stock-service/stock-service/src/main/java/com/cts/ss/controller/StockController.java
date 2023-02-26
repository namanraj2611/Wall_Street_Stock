package com.cts.ss.controller;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.exception.DepartmentException;
import com.cts.ss.model.Stock;
import com.cts.ss.service.StockService;



@RestController
@RequestMapping("/user")
public class StockController {

	@Autowired
	StockService service;
	
	@GetMapping("/stocks")
	public List<Stock> getStocks(){
		return service.getStocks();
	}
	
	@PostMapping("/addStock")
	public String add(@RequestBody Stock stock) {
		service.saveStock(stock);
		return "New Stock is added";
	}
	
//	@DeleteMapping("/deleteStocks")
//	public String delete(@RequestBody Stock stock) {
//		service.saveStock(stock);
//		return "Stock is deleted";
//	}
	
	
	}
	
	
	
