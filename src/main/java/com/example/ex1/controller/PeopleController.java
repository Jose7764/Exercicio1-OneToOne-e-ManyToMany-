package com.example.ex1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ex1.dto.people.PeopleAndDocumentRequest;
import com.example.ex1.dto.people.PeopleRequest;
import com.example.ex1.dto.people.PeopleResponse;
import com.example.ex1.service.PeopleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PeopleController {

    private final PeopleService service;

    @PostMapping("/create")
    public ResponseEntity<PeopleResponse> create(@RequestBody PeopleRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(service.create(dto));
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<PeopleResponse>> listAll() {
        return ResponseEntity.status(HttpStatus.OK)
                             .body(service.listAll());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<PeopleResponse> listById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK)
                             .body(service.listById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PeopleResponse> update(@PathVariable long id, @RequestBody PeopleRequest dto) {
        return ResponseEntity.status(HttpStatus.OK)
                             .body(service.update(dto, id));
    }

    @PostMapping("/createWith")
    public ResponseEntity<PeopleResponse> createWithDocument(@RequestBody PeopleAndDocumentRequest dto){
        return ResponseEntity.status(HttpStatus.OK)
                            .body(service.createWithDocument(dto));
    }
}