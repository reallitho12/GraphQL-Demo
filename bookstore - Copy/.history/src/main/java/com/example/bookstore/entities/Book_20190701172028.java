package com.example.bookstore.entities;

import lombok.Data;
import javax.persistence.*;
import com.example.bookstore.enums.*;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;
    private String author;
    private Genre genre;
    private int isbn;
    private int quantity;
}