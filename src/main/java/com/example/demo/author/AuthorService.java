package com.example.demo.author;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    Author createAuthor(Author author);
    void deleteAuthor(Integer id);
    Author readAuthor(Integer id);
    List<Author> readAuthors();
    Author updateAuthor(Integer id,Author author);
}
