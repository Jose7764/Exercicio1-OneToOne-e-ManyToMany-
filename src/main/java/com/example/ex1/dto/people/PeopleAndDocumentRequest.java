package com.example.ex1.dto.people;

import com.example.ex1.dto.document.DocumentRequest;
import com.example.ex1.model.Document;

public record PeopleAndDocumentRequest (
    String name,
    Document document
){
}
