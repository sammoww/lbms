package com.example.demo.book;

import com.example.demo.exception.EntityAlreadyExistsException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/getBook/{isbn}")
    public Book getBookByIsbn(@PathVariable int isbn){
        return bookService.getBookByIsbn(isbn);
    }

    @GetMapping("/getBooks")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PutMapping("/update/{isbn}")
    ResponseEntity<String> updateBook(@PathVariable int isbn, @RequestBody Book bookDetails){
        return bookService.updateBook(isbn, bookDetails);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book bookDetails){
        Book addedBook = bookService.addBook(bookDetails);
        String responseMessage = "The book with isbn "+ addedBook.getIsbn()+ " has been added.";
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
    }

    @DeleteMapping("/delete/{isbn}")
    public ResponseEntity<String> deleteBook(@PathVariable int isbn) {
        return bookService.deleteBook(isbn);
    }

}
