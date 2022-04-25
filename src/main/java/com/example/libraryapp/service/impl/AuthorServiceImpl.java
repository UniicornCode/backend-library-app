package com.example.libraryapp.service.impl;

import com.example.libraryapp.model.Author;
import com.example.libraryapp.repository.AuthorRepository;
import com.example.libraryapp.service.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> listAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    @Transactional
    public void save(Author author) {
        authorRepository.save(author);
    }
}
