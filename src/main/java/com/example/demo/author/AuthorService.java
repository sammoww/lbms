package com.example.demo.author;

import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
    Author createAuthor(Author author);
    void deleteAuthor(Integer id);
    Author readAuthor(Integer id);
    Author updateAuthor(Integer id,Author author);
}
