package com.example.bookstore.repositories;

import com.example.bookstore.entities.*;
import com.example.bookstore.enums.*;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
    Optional<Book> findByTitle(String title);
    Optional<Book> findByAuthor(String author);
    Optional<Book> findByGenre(Genre genre);
    Optional<Book> findByIsbn(int isbn);
}