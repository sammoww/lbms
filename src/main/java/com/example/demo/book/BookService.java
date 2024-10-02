package com.example.demo.book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> getBookByIsbn(int isbn);

    Book addBook(Book book);

    Book updateBook(int isbn, Book bookDetails);

    void deleteBook(int isbn);

    List<Book> getAllBooks();
}
