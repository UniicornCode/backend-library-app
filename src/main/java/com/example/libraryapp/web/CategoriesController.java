package com.example.libraryapp.web;

import com.example.libraryapp.enumeration.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoriesController {

    @GetMapping
    public List<Category> listAll() {
        return List.of(Category.values());
    }
}
