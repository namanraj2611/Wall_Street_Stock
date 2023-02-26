package com.cts.portfolioservice.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.portfolioservice.entities.Booking;
import com.cts.portfolioservice.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
	List<Payment> findByBooking(Booking booking);

}
