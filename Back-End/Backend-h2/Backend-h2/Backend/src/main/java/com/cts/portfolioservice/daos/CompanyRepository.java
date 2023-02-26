package com.cts.portfolioservice.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.portfolioservice.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
