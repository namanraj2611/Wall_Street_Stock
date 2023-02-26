package com.cts.ss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.ss.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {

}
