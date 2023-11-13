package com.example.controller;

import com.example.model.Book;
import com.example.model.SortType;
import com.example.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rest/book")
public class BookRestController {
    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) LocalDate beginPublicationDate,
            @RequestParam(required = false) LocalDate endPublicationDate,
            @RequestParam(required = false) String authorName,
            @RequestParam(required = false) SortType sortType) {
        return bookService.getBooks(title, beginPublicationDate, endPublicationDate, authorName, sortType);
    }

    @PostMapping
    public boolean add(@RequestBody Book book) {
        return bookService.add(book);
    }
}
