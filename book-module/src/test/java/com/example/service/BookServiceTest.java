package com.example.service;

import com.example.model.Author;
import com.example.model.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookServiceTest {
    private final BookService bookService;

    public BookServiceTest(BookService bookService) {
        this.bookService = bookService;
    }

    @Test
    public void givenBookObject_whenAddObject_thenReturnTrue() {
        Book book = testBook();

        assertTrue(bookService.add(book));
    }

    @Test
    public void givenTwoSameBookObjects_whenAddBoth_thenReturnFalse() {
        Book book1 = testBook();
        Book book2 = testBook();

        assertTrue(bookService.add(book1));
        assertFalse(bookService.add(book2));
    }

    private Book testBook() {
        return new Book(
                "The Lord of the Rings: The Fellowship of the Ring",
                "Allen & Unwin",
                LocalDate.of(1954, Month.JULY, 29),
                new Author("John", "Tolkien", LocalDate.of(1892, Month.JANUARY, 3))
        );
    }
}
