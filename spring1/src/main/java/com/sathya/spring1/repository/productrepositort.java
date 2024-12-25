package com.sathya.spring1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.spring1.entity.productEntity;

@Repository
public interface productrepositort extends JpaRepository<productEntity, Long> {

}
