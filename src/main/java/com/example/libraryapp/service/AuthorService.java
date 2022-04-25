package com.example.libraryapp.service;

import com.example.libraryapp.model.Author;
import com.example.libraryapp.model.Book;
import com.example.libraryapp.model.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAll ();
    Optional<Author> findById (Long id);
    void save (Author author);
}
