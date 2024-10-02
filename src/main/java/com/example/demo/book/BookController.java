package com.example.demo.book;

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
    public Book getBooksByIsbn(@PathVariable int isbn){
       return bookService.getBookByIsbn(isbn).orElseThrow();
    }

    @GetMapping("/getBooks")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PutMapping("/update/{isbn}")
    Book updateBook(@PathVariable int isbn, @RequestBody Book bookDetails){
        return bookService.updateBook(isbn, bookDetails);
    }

    @PostMapping("/add")
    Book addBook(@RequestBody Book bookDetails){
        return bookService.addBook(bookDetails);
    }

    @DeleteMapping("/delete/{isbn}")
    void deleteBook(@PathVariable int isbn){
        bookService.deleteBook(isbn);
    }

}
