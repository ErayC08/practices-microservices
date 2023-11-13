package com.example.repository;

import com.example.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private final List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }
}
