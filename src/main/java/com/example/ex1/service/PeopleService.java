package com.example.ex1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ex1.dto.people.PeopleAndDocumentRequest;
import com.example.ex1.dto.people.PeopleRequest;
import com.example.ex1.dto.people.PeopleResponse;
import com.example.ex1.mapper.PeopleMapper;
import com.example.ex1.model.Document;
import com.example.ex1.model.People;
import com.example.ex1.repository.DocumentRepository;
import com.example.ex1.repository.PeopleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PeopleService {
    
    private final PeopleMapper mapper;
    private final PeopleRepository repository;
    private final DocumentRepository repositoryDocument;

    public PeopleResponse create(PeopleRequest dto){
        return mapper.toResponse(repository.save(mapper.toEntity(dto)));
    }

    public PeopleResponse createWithDocument(PeopleAndDocumentRequest dto){
        Document document = new Document(dto.document().getNumber(), dto.document().getType());
        Document savedDocument = repositoryDocument.save(document);

        People people = new People(dto.name(), savedDocument);
        return mapper.toResponse(repository.save(people));
    }

    public List<PeopleResponse> listAll(){
        return repository.findAll()
                            .stream()
                            .map(mapper::toResponse)
                            .toList();
    }

    public PeopleResponse listById(long id){
        People people = repository.findById(id).orElseThrow(()-> new RuntimeException("There is not people which ID is "+ id));

        return mapper.toResponse(people);
    }

    public PeopleResponse update(PeopleRequest dto, long id){
        People people = repository.findById(id).orElseThrow(()-> new RuntimeException("There is not people which ID is "+ id));
        
        people.setName(dto.name());

        return mapper.toResponse(repository.save(people));
    }
}
