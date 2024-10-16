package com.example.demo.book;

import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    private BookRepo bookRepo;

    BookServiceImpl(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }

    @Override
    public Book getBookByIsbn(Integer isbn) {
        if (!bookRepo.existsByIsbn(isbn)){
            throw new EntityNotFoundException("message: Book Not Found!!");
        } else
            return bookRepo.findByIsbn(isbn);
    }

    @Override
    public Book addBook(Book book) {
        if(bookRepo.existsByIsbn(book.getIsbn())){
            throw new EntityAlreadyExistsException("Book already exists");
        }else
            return bookRepo.save(book);
    }

    @Override
    public ResponseEntity<String> updateBook(int isbn, Book bookDetails) {
        if (!bookRepo.existsByIsbn(isbn)) throw new EntityNotFoundException("Book not found ");
        Book book = bookRepo.findByIsbn(isbn);
        book.setBookName(bookDetails.getBookName());
        book.setAuthor(bookDetails.getAuthor());
        return ResponseEntity.status(HttpStatus.OK).body("Book has been updated.\n Updated Book's Details:\n" + book.toString());
    }

    @Override
    public ResponseEntity<String> deleteBook(int isbn) {
        if(!bookRepo.existsByIsbn(isbn)) {
            throw new EntityNotFoundException("Book with isbn: "+isbn+" not found.");
        }else {
            bookRepo.deleteById(isbn);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Message: Book with isbn " + isbn + " has been successfully deleted" );
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
}
