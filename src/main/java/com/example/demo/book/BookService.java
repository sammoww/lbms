package com.example.demo.book;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book getBookByIsbn(Integer isbn);

    Book addBook(Book book);

    ResponseEntity<String> updateBook(int isbn, Book bookDetails);

    ResponseEntity<String> deleteBook(int isbn);

    List<Book> getAllBooks();
}
