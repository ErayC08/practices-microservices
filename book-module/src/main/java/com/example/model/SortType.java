package com.example.model;

import java.util.Comparator;

public enum SortType {
    BY_TITLE, BY_PUBLICATION_DATE, BY_AUTHOR;

    public static Comparator<Book> toComparator(SortType sortType) {
        return switch (sortType) {
            case BY_PUBLICATION_DATE -> Comparator.comparing(Book::getPublicationDate);
            case BY_AUTHOR -> Comparator.comparing(Book::getAuthor);
            default -> Comparator.comparing(Book::getTitle);
        };
    }
}
