package com.example.bookstore.repositories;

import com.example.bookstore.entities.*;
import com.example.bookstore.enums.*;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByGenre(Genre genre);
    List<Book> findByIsbn(int isbn);
}