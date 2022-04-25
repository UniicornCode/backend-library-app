package com.example.libraryapp.service;

import com.example.libraryapp.model.Book;
import com.example.libraryapp.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> listAll ();
    Optional<Country> findById (Long id);
    void save (Country country);
}
