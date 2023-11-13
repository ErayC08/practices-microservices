package com.example.model;

import java.time.LocalDate;
import java.util.Objects;

public class Author implements Comparable<Author> {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Author(String firstName, String lastName, LocalDate birthDate) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new NullPointerException("The first name is missing.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new NullPointerException("The last name is missing.");
        }
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        if (birthDate == null) {
            throw new NullPointerException("The birth-date is missing.");
        }
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Author that = (Author) o;

        return firstName.equals(that.firstName) && lastName.equals(that.lastName) && birthDate.equals(that.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate);
    }

    @Override
    public int compareTo(Author that) {
        int compareToFirstName = firstName.compareTo(that.firstName);

        return compareToFirstName == 0 ? compareToLastName(that) : compareToFirstName;
    }

    private int compareToLastName(Author that) {
        return lastName.compareTo(that.lastName);
    }
}
