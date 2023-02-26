package com.cts.portfolioservice.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.portfolioservice.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

}
