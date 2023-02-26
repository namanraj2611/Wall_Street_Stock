package com.cts.portfolioservice.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.portfolioservice.entities.Customer;
import com.cts.portfolioservice.entities.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

	List<Feedback> findByCustomer(Customer customer);
}
