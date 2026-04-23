package com.example.ex1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ex1.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{
    
}
