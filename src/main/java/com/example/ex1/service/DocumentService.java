package com.example.ex1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ex1.dto.document.DocumentRequest;
import com.example.ex1.dto.document.DocumentResponse;
import com.example.ex1.mapper.DocumentMapper;
import com.example.ex1.model.Document;
import com.example.ex1.repository.DocumentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocumentService {
    
    private final DocumentMapper mapper;
    private final DocumentRepository repository;

    public DocumentResponse create(DocumentRequest dto){
        return mapper.toResponse(repository.save(mapper.toEntity(dto)));
    }

    public List<DocumentResponse> listAll(){
        return repository.findAll()
        .stream()
        .map(mapper::toResponse)
        .toList();
    }

    public DocumentResponse listById(long id){
    
        Document document = repository.findById(id).orElseThrow(()-> new RuntimeException("There is not Document which ID is "+ id));
        return mapper.toResponse(document);
    }

    public DocumentResponse update(DocumentRequest dto, long id){
        Document document = repository.findById(id).orElseThrow(()-> new RuntimeException("There is not Document which ID is "+ id));

        document.setNumber(dto.number());
        document.setType(dto.type());

        return mapper.toResponse(repository.save(document));
    }


}
