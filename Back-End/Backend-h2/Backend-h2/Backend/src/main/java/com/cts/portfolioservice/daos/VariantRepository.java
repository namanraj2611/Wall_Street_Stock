package com.cts.portfolioservice.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.portfolioservice.entities.Company;
import com.cts.portfolioservice.entities.Variant;

@Repository
public interface VariantRepository extends JpaRepository<Variant, Integer> {

	List<Variant> findByCompany(Company company);
}
