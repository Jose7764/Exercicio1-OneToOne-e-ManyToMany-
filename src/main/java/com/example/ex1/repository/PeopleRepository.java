package com.example.ex1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ex1.model.People;

public interface PeopleRepository extends JpaRepository<People, Long>{
    
}
