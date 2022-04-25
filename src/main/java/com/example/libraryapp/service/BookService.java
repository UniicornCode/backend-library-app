package com.example.libraryapp.service;

import com.example.libraryapp.model.Author;
import com.example.libraryapp.model.Book;
import com.example.libraryapp.model.dto.BookDto;

import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listAll ();
    Optional<Book> findById (Long id);
    Optional<Book> save(BookDto bookDto);
    Optional<Book> edit(Long id, BookDto bookDto);
    void markAsTaken(Long id);
    void deleteById(Long id);
}
