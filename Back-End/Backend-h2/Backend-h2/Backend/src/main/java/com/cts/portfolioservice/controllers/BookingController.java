package com.cts.portfolioservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.portfolioservice.models.BookingCompleteDTO;
import com.cts.portfolioservice.models.BookingDTO;
import com.cts.portfolioservice.models.BookingStatusDTO;
import com.cts.portfolioservice.services.BookingService;

@CrossOrigin
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

	@Autowired private BookingService bservice;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody BookingDTO dto) {		
		bservice.saveBooking(dto);
		return ResponseEntity.ok("Order successfully");
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateStatus(@PathVariable("id") int id,@RequestBody BookingStatusDTO dto) {
		dto.setBid(id);
		bservice.updateBooking(dto);
		return ResponseEntity.ok("Buy Succesfuly");
	}
	
	@PutMapping("complete/{id}")
	public ResponseEntity<?> completeBooking(@PathVariable("id") int id,@RequestBody BookingCompleteDTO dto) {
		dto.setBid(id);
		bservice.completeBooking(dto);
		return ResponseEntity.ok("Buy Completed");
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {		
		return ResponseEntity.ok(bservice.findAllBookings());
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> findCustomerBookings(String userid) {		
		return ResponseEntity.ok(bservice.findUserBookings(userid));
	}
	
	@GetMapping("/feedbacks")
	public ResponseEntity<?> allFeedbacks() {		
		return ResponseEntity.ok(bservice.allFeedbacks());
	}
	
	@GetMapping("/payments/{id}")
	public ResponseEntity<?> findAllPayments(@PathVariable("id") int id) {		
		return ResponseEntity.ok(bservice.findBookingPayments(id));
	}
	
	@GetMapping("/payments")
	public ResponseEntity<?> findallPayments() {		
		return ResponseEntity.ok(bservice.findAllPayments());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable("id") int id) {		
		return ResponseEntity.ok(bservice.findById(id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
		bservice.cancelBooking(id);
		return ResponseEntity.ok("Successfully Sold");
	}
}
