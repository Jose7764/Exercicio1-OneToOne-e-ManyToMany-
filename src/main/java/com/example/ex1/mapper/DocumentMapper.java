package com.example.ex1.mapper;

import org.springframework.stereotype.Component;

import com.example.ex1.dto.document.DocumentRequest;
import com.example.ex1.dto.document.DocumentResponse;
import com.example.ex1.model.Document;

@Component
public class DocumentMapper {
    
    public Document toEntity(DocumentRequest dto){

        return new Document(
            dto.number(),
            dto.type() 
        );
    }

    public DocumentResponse toResponse(Document dto){
        return new DocumentResponse(
            dto.getId(),
            dto.getNumber(),
            dto.getType()
        );
    }
}
