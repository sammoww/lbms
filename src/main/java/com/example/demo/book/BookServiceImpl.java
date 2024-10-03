package com.example.demo.book;

import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
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
    public Book updateBook(int isbn, Book bookDetails) {
        Book book = bookRepo.findById(isbn)
                .orElseThrow(()-> new EntityNotFoundException("Book not found "));
        book.setBookName(bookDetails.getBookName());
        book.setAuthor(bookDetails.getAuthor());
        return bookRepo.save(book);
    }

    @Override
    public void deleteBook(int isbn) {
        bookRepo.deleteById(isbn);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
}
