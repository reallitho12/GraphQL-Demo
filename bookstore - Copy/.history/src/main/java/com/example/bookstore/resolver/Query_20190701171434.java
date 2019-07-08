package com.example.bookstore.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.bookstore.entities.*;
import com.example.bookstore.repositories.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLResolver<Book>{

    private BookRepository bookRepository;

    public Optional<Book> book(long id) {
        return bookRepository.findById(id);
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}