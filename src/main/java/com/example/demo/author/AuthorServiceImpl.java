package com.example.demo.author;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{
    private AuthorRepo authorRepo;

    AuthorServiceImpl(AuthorRepo authorRepo){
        this.authorRepo = authorRepo;
    }
    @Override
    public Author createAuthor(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public void deleteAuthor(Integer id) {
        authorRepo.deleteById(id);
    }

    @Override
    public Author readAuthor(Integer id) {
        return authorRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Author> readAuthors() {
        return authorRepo.findAll();
    }

    @Override
    public Author updateAuthor(Integer id, Author author) {
        Author updateAuthorEntity = authorRepo.findById(id).orElseThrow();
        updateAuthorEntity.setName(author.getName());
        return authorRepo.save(updateAuthorEntity);

    }
}
