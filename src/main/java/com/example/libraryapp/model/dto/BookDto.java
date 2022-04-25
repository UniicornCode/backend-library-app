package com.example.libraryapp.model.dto;

import com.example.libraryapp.enumeration.Category;
import com.example.libraryapp.model.Author;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Data
public class BookDto {

    private String name;
    @Enumerated(value = EnumType.STRING)
    private Category category;
    private Long author;
    private Integer availableCopies;

    public BookDto(String name, Category category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
