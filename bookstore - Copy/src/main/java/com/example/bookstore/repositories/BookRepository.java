package com.example.bookstore.repositories;

import com.example.bookstore.entities.*;
import com.example.bookstore.enums.*;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    Optional<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByGenre(Genre genre);
    Optional<Book> findByIsbn(int isbn);
}