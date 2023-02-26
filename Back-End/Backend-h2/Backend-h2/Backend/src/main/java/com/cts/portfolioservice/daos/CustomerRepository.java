package com.cts.portfolioservice.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.portfolioservice.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
