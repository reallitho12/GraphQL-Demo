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

    public Optional<Book> restockBook(String title, int quantity) {
        Optional<Book> book = bookRepository.findByTitle(title);
        book.ifPresent(b -> {
            b.setQuantity(b.getQuantity()+quantity);
            bookRepository.save(b);
            System.out.println(title + " has been restocked!");
        });

        return book;
    }

    public Optional<Book> buyBook(String title, int quantity) {
        Optional<Book> book = bookRepository.findByTitle(title);
        book.ifPresent(b -> {
            if (b.getQuantity() >= quantity){
                b.setQuantity(b.getQuantity()-quantity);
                bookRepository.save(b);
            } else {
                System.out.println("Not enough copies of " + title + "!");
            }
            
        });

        return book;
    }

    public boolean removeBook(String title) {
        Optional<Book> book = bookRepository.findByTitle(title);
        book.ifPresent(b -> {
            bookRepository.deleteById(b.getId());
        });
        return true;
    }
}