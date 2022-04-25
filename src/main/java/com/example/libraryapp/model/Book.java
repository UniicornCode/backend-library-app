package com.example.libraryapp.model;

import com.example.libraryapp.enumeration.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Category category;
    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;
    private Integer availableCopies;

    public Book() {
    }

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
