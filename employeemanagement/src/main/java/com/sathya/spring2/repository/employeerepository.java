package com.sathya.spring2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.spring2.entity.employeeentity;

@Repository
public interface employeerepository extends JpaRepository<employeeentity, Long> {

}
