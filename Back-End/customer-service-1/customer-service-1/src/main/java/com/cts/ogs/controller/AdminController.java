package com.cts.ogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ogs.controller.model.LoginDTO;
import com.cts.ogs.controller.model.Admin;
import com.cts.ogs.controller.model.Response;
import com.cts.ogs.service.AdminService;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired 
	AdminService adminService;
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO dto) {
		System.out.println(dto);
		Admin admin=adminService.validate(dto.getUserid(),dto.getPwd());
		if(admin!=null)
			return ResponseEntity.ok(admin);
		else
			return Response.status(HttpStatus.NOT_FOUND);
	}
	
//	@PostMapping
//	public ResponseEntity<?> updateProfile(@RequestBody Admin admin) {
//		adminService.updateAdmin(admin);
//		return ResponseEntity.status(HttpStatus.OK).build();
//	}
}
