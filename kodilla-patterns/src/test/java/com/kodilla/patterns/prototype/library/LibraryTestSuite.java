package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("My Library");

        Set<Book> myBooks = new HashSet<>();
        Book book1 = new Book("Dylan Murphy", "Wolf of the mountains", LocalDate.of(2003, 11, 11));
        myBooks.add(book1);
        myBooks.add(new Book("Phoebe Pearson", "Slaves of dreams", LocalDate.of(2012, 12, 14)));
        myBooks.add(new Book("Morgan Walsh", "Obliteration of heaven", LocalDate.of(2001, 01, 01)));
        myBooks.add(new Book("Aimee Murphy", "Rejecting the night", LocalDate.of(2015, 01, 01)));
        myBooks.add(new Book("Ryan Talley", "Gangsters and kings", LocalDate.of(2007, 01, 01)));
        myBooks.add(new Book("Madelynn Carson", "Unity without duty", LocalDate.of(2007, 12, 31)));
        myBooks.add(new Book("Giancarlo Guerrero", "Enemies of eternity", LocalDate.of(2009, 06, 06)));

        for (Book book : myBooks) {
            library.getBooks().add(book);
        }

        // making a shallow clone
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.makeShallowCopy();
            clonedLibrary.setName("The shallow clone of My Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        System.out.println(library);
        System.out.println(clonedLibrary);

        //When
        library.getBooks().add(new Book("W pustyni i w puszczy", "Henryk Sienkiewicz", LocalDate.of(1911, 12, 03)));

        //Then
        Assert.assertEquals(8, library.getBooks().size());
        Assert.assertEquals(8, clonedLibrary.getBooks().size());
        System.out.println("\nMy new library after adding new book: " + library);
        System.out.println("\nMy new cloned library after adding new book: " + clonedLibrary);

        // making a deep clone
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.makeDeepCopy();
            deepClonedLibrary.setName("The deep clone of My Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);

        //When
        library.getBooks().remove(book1);

        //Then
        System.out.println("\nMy new library after adding new book, and deleting one: " + library);
        System.out.println("\nMy new shallow cloned library after adding new book, and deleting one: : " + clonedLibrary);
        System.out.println("\nMy new deep cloned library after adding new book, and deleting one: : " + deepClonedLibrary);

        Assert.assertEquals(7, library.getBooks().size());
        Assert.assertEquals(7, clonedLibrary.getBooks().size());
        Assert.assertEquals(8, deepClonedLibrary.getBooks().size());
        Assert.assertEquals(library.getBooks(),clonedLibrary.getBooks());
        Assert.assertNotEquals(library.getBooks(),deepClonedLibrary.getBooks());
    }
}