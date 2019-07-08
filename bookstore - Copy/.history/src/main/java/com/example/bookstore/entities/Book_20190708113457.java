package com.example.bookstore.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import com.example.bookstore.enums.*;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String author;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private int isbn;
    private int quantity;

    public Book(String title, String author, Genre genre, int isbn, int quantity){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.quantity = quantity;
    }
}