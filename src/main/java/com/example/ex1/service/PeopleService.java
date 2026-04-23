package com.example.ex1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ex1.dto.people.PeopleRequest;
import com.example.ex1.dto.people.PeopleResponse;
import com.example.ex1.mapper.PeopleMapper;
import com.example.ex1.model.People;
import com.example.ex1.repository.PeopleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PeopleService {
    
    private PeopleMapper mapper;
    private PeopleRepository repository;

    public PeopleResponse create(PeopleRequest dto){
        return mapper.toResponse(repository.save(mapper.toEntity(dto)));
    }

    public List<PeopleResponse> listAll(){
        return repository.findAll()
                            .stream()
                            .map(mapper::toResponse)
                            .toList();
    }

    public PeopleResponse listById(long id){
        People people = repository.findById(id).orElseThrow(()-> new RuntimeException("There is not people with this id!"));

        return mapper.toResponse(people);
    }
}
