package com.example.ex1.dto.people;

import com.example.ex1.model.Document;
public record PeopleResponse (
    long id, 
    String nome, 
    Document document
){
    
}
