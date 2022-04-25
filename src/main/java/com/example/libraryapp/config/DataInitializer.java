package com.example.libraryapp.config;

import com.example.libraryapp.enumeration.Category;
import com.example.libraryapp.model.Author;
import com.example.libraryapp.model.Book;
import com.example.libraryapp.model.Country;
import com.example.libraryapp.model.dto.BookDto;
import com.example.libraryapp.service.AuthorService;
import com.example.libraryapp.service.BookService;
import com.example.libraryapp.service.CountryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final BookService bookService;

    private final AuthorService authorService;

    private final CountryService countryService;

    public DataInitializer(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @PostConstruct
    public void initData() {
        Country country = new Country("Macedonia", "Europe");
        this.countryService.save(country);

        Author author = new Author("Natali", "Varga", country);
        this.authorService.save(author);
        Author author1 = new Author("Mario", "Varga", country);
        this.authorService.save(author1);
        Author author2 = new Author("Anni", "Roger", country);
        this.authorService.save(author2);

        BookDto bookDto = new BookDto("Dogs", Category.FANTASY, author.getId(), 10);
        this.bookService.save(bookDto);
        BookDto bookDto1 = new BookDto("Plants", Category.BIOGRAPHY, author1.getId(), 20);
        this.bookService.save(bookDto1);
        BookDto bookDto2 = new BookDto("Coefficient of Love", Category.DRAMA, author2.getId(), 5);
        this.bookService.save(bookDto2);
        BookDto bookDto3 = new BookDto("Don Quixote", Category.CLASSICS, author1.getId(), 25);
        this.bookService.save(bookDto3);
        BookDto bookDto4 = new BookDto("Sims", Category.NOVEL, author2.getId(), 30);
        this.bookService.save(bookDto4);
        BookDto bookDto5 = new BookDto("History of the Moon", Category.HISTORY, author.getId(), 20);
        this.bookService.save(bookDto5);
    }
}
