package com.example.service;

import com.example.model.Author;
import com.example.model.Book;
import com.example.model.SortType;
import com.example.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(String title,
                               LocalDate beginPublicationDate,
                               LocalDate endPublicationDate,
                               String authorName,
                               SortType sortType) {

        return bookRepository.getBooks()
                .stream()
                .filter(titlePredicate(title)
                        .and(publicationDatePredicate(beginPublicationDate, endPublicationDate))
                        .and(authorPredicate(authorName)))
                .sorted(SortType.toComparator(sortType))
                .toList();
    }

    public boolean add(Book book) {
        List<Book> books = bookRepository.getBooks();

        for (Book b : books) {
            if (b.equals(book)) {
                return false;
            }
        }
        return books.add(book);
    }

    private Predicate<Book> titlePredicate(String title) {
        return book -> title == null || book.getTitle().contains(title);
    }

    private Predicate<Book> publicationDatePredicate(LocalDate beginPublicationDate, LocalDate endPublicationDate) {
        return book -> {
            LocalDate publicationDate = book.getPublicationDate();

            return (beginPublicationDate == null || beginPublicationDate.isBefore(publicationDate)) && (endPublicationDate == null || endPublicationDate.isAfter(publicationDate));
        };
    }

    private Predicate<Book> authorPredicate(String name) {
        return book -> {
            Author author = book.getAuthor();

            return name == null || author.getFirstName().contains(name) || author.getLastName().contains(name);
        };
    }
}
