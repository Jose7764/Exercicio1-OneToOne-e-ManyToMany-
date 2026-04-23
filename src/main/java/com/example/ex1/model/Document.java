package com.example.ex1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Document {
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private int number;
    private String type;

    public Document(int number, String type) {
        this.number = number;
        this.type = type;
    }
}
