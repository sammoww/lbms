package com.example.demo.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer > {
    Boolean existsByIsbn(Integer isbn);
    Book findByIsbn(Integer isbn);
}
