package com.cts.ogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.ogs.controller.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

}
