package com.example.libraryapp.service.impl;

import com.example.libraryapp.model.Country;
import com.example.libraryapp.repository.CountryRepository;
import com.example.libraryapp.service.CountryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    @Transactional
    public void save(Country country) {
        countryRepository.save(country);
    }
}
