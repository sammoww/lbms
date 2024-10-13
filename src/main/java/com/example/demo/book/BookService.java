package com.example.demo.book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book getBookByIsbn(Integer isbn);

    Book addBook(Book book);

    Book updateBook(int isbn, Book bookDetails);

    Boolean deleteBook(int isbn);

    List<Book> getAllBooks();
}
