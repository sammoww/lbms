package com.example.demo.author;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping("/getAuthor/{id}")
    public Author readAuthor(@PathVariable Integer id){
        return authorService.readAuthor(id);
    }

    @PutMapping("/createAuthor")
    public Author createAuthor(@RequestBody Author author){
        return authorService.createAuthor(author);
    }

    @PostMapping("/updateAuthor/{id}")
    public Author updateAuthor(@PathVariable Integer id, @RequestBody Author author){
        return authorService.updateAuthor(id,author);
    }

    @DeleteMapping("/deleteAuthor/{id}")
    public void deleteAuthor(@PathVariable Integer id){
        authorService.deleteAuthor(id);
    }
}
