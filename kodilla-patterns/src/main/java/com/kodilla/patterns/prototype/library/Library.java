package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype {
    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String s = "\nLibrary: " + name + "\n";
        for (Book book : books) {
            s = s + book.toString();
        }
        return s;
    }

    public Library makeShallowCopy() throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    public Library makeDeepCopy() throws CloneNotSupportedException {
        Library deepClonedLibrary = (Library) super.clone();
        deepClonedLibrary.books = new HashSet<>();
        for (Book theBook : books) {
            Book deepClonedBooks = new Book(theBook.getTitle(), theBook.getAuthor(), theBook.getPublicationDate());
            deepClonedLibrary.getBooks().add(deepClonedBooks);
        }
        return deepClonedLibrary;
    }
}

