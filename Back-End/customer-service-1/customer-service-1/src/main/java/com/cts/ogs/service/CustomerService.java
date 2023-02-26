package com.cts.ogs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cts.ogs.controller.model.Customer;
import com.cts.ogs.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired 
	CustomerRepository dao;
	
	public void registerCustomer(Customer cust) {
		dao.save(cust);
	}
	
	public Customer findByUserId(int userid) {
		return dao.getById(userid);
	}

	public List<Customer> allCustomers() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public Customer validate(String userid, String pwd) {
		Customer cc=dao.getById(userid);
		if(cc!=null && cc.getPwd().equals(pwd)) {
			return cc;
		}
		return null;
	}
	
	public boolean verifyUserId(String userid) {
		// TODO Auto-generated method stub
		return dao.existsById(userid);
	}
	
//	public void updateProfile(Customer cust) {
//		// TODO Auto-generated method stub
//		if(cust.getPwd().equals("") || cust.getPwd()==null) {
//			cust.setPwd(dao.getById(cust.getId()).getPwd());
//		}
//		dao.save(cust);	
//	}
}
