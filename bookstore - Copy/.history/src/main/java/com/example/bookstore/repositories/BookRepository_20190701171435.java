package com.example.bookstore.repositories;

import com.example.bookstore.entities.*;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {}