package com.example.bookstore.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.bookstore.entities.*;
import com.example.bookstore.enums.*;
import com.example.bookstore.repositories.BookRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;

    public Mutation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book newBook(String title, String author, Genre genre, int isbn, int quantity) {
        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        book.setGenre(genre);
        book.setIsbn(isbn);
        book.setQuantity(quantity);

        bookRepository.save(book);

        return book;
    }

    public Optional<Book> restockBook(Long id, int quantity) {
        Optional<Book> book = bookRepository.findById(id);
        book.ifPresent(b -> {
            b.setQuantity(b.getQuantity()+quantity);
            bookRepository.save(b);
        });

        return book;
    }

    public boolean removeBook(long id) {
        bookRepository.deleteById(id);
        return true;
    }
}