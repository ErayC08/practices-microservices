package com.example.model;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private String title;
    private String publisher;
    private LocalDate publicationDate;
    private Author author;
    private AssignmentDetails assignmentDetails;

    public Book(String title, String publisher, LocalDate publicationDate, Author author) {
        setTitle(title);
        setPublisher(publisher);
        setPublicationDate(publicationDate);
        setAuthor(author);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public AssignmentDetails getAssignmentDetails() {
        return assignmentDetails;
    }

    public void assign(Student assignee, LocalDate dueDate) {
        this.assignmentDetails = new AssignmentDetails(assignee, dueDate);
    }

    public boolean isAssigned() {
        return assignmentDetails != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book that = (Book) o;

        return Objects.equals(title, that.title) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}
