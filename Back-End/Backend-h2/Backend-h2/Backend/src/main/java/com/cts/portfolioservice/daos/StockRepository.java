package com.cts.portfolioservice.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.portfolioservice.entities.Stock;
import com.cts.portfolioservice.entities.Variant;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {

	List<Stock> findByVariantAndStatus(Variant variant,String status);
	List<Stock> findByStatus(String status);
}
