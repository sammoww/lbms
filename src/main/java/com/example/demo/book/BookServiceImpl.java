package com.example.demo.book;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    private BookRepo bookRepo;

    BookServiceImpl(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }
    @Override
    public Optional<Book> getBookByIsbn(int isbn) {
        return bookRepo.findById(isbn);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book updateBook(int isbn, Book bookDetails) {
        Book book = bookRepo.findById(isbn).orElseThrow();
        book.setBookName(bookDetails.getBookName());
        book.setAuthor(bookDetails.getAuthor());
        return bookRepo.save(book);
    }

    @Override
    public void deleteBook(int isbn) {
        bookRepo.deleteById(isbn);
    }
}
