package com.example.bookstore.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.bookstore.entities.*;
import com.example.bookstore.repositories.*;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    private BookRepository bookRepository;

    public Query(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> book(long id) {
        return bookRepository.findById(id);
    }

    public List<Book> title(String title) {
        return bookRepository.findByTitle(title);
    }

    

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}