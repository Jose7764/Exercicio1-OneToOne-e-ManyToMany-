package com.example.ex1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex1.dto.document.DocumentRequest;
import com.example.ex1.dto.document.DocumentResponse;
import com.example.ex1.service.DocumentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/document")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService service;
    
    @PostMapping("/create")
    public ResponseEntity<DocumentResponse> create(@RequestBody DocumentRequest dto){
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(service.create(dto));
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<DocumentResponse>> listAll(){
        return ResponseEntity.status(HttpStatus.OK)
        .body(service.listAll());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<DocumentResponse> listById(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK)
            .body(service.listById(id));
        
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DocumentResponse> update(@PathVariable long id, @RequestBody DocumentRequest dto){
        return ResponseEntity.status(HttpStatus.OK)
        .body(service.update(dto, id));
    }
}
