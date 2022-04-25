package com.example.libraryapp.service.impl;

import com.example.libraryapp.model.Author;
import com.example.libraryapp.model.Book;
import com.example.libraryapp.model.dto.BookDto;
import com.example.libraryapp.model.exception.BookNotFoundException;
import com.example.libraryapp.repository.AuthorRepository;
import com.example.libraryapp.repository.BookRepository;
import com.example.libraryapp.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository1) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository1;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Book> save(BookDto bookDto) {
        Author author = authorRepository.getById(bookDto.getAuthor());
        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());
        return Optional.of(bookRepository.save(book));
    }

    @Override
    @Transactional
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.setName(bookDto.getName());
        Author author = authorRepository.getById(bookDto.getAuthor());
        book.setAuthor(author);
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public void markAsTaken(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
