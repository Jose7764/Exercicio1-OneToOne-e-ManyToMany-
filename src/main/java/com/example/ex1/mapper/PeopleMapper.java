package com.example.ex1.mapper;

import org.springframework.stereotype.Component;

import com.example.ex1.dto.people.PeopleRequest;
import com.example.ex1.dto.people.PeopleResponse;
import com.example.ex1.model.People;

@Component
public class PeopleMapper {
    
    public People toEntity(PeopleRequest dto){
        return new People(
            dto.name()
        );
    }

    public PeopleResponse toResponse(People dto){
        return new PeopleResponse(
            dto.getId(),
            dto.getName(),
            dto.getDocument()
        );
    }
}
