package com.kodilla.testing.library;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class BookDirectoryTestSuite {

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksWithConditionsReturnList() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secrets"))
                .thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secrets");

        // Then
        Assert.assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        // Then
        Assert.assertEquals(0, theListOfBooks0.size());
        Assert.assertEquals(15, theListOfBooks15.size());
        Assert.assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf10Books);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        Assert.assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListWith0BooksInHandsOn() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        LibraryUser libraryUser0 = new LibraryUser("Jan", "Kowalski", "123456789");
        List<Book> rented0BookList = generateListOfNBooks(0);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser0)).thenReturn(rented0BookList);

        //When
        List<Book> listWith0BooksInHandsOnLibraryUser = bookLibrary.listBooksInHandsOf(libraryUser0);

        //Then
        Assert.assertEquals(0, listWith0BooksInHandsOnLibraryUser.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(libraryUser0);
    }

    @Test
    public void testListWith1BookInHandsOn() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        LibraryUser libraryUser1 = new LibraryUser("Zuzanna", "Nowak", "987654321");
        List<Book> rented1BookList = generateListOfNBooks(1);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser1)).thenReturn(rented1BookList);

        //When
        List<Book> listWith1BooksInHandsOnLibraryUser = bookLibrary.listBooksInHandsOf(libraryUser1);

        //Then
        Assert.assertEquals(1, listWith1BooksInHandsOnLibraryUser.size());
        Assert.assertEquals("Title 1", listWith1BooksInHandsOnLibraryUser.get(0).getTitle());
    }

    @Test
    public void testListWith5BookInHandsOn() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        LibraryUser libraryUser5 = new LibraryUser("John", "Smith", "54654564845");
        List<Book> theRentedBookList = generateListOfNBooks(5);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser5)).thenReturn(theRentedBookList);

        //When
        List<Book> listWith5BooksInHandsOnLibraryUser = bookLibrary.listBooksInHandsOf(libraryUser5);

        //Then
        Assert.assertEquals(5, listWith5BooksInHandsOnLibraryUser.size());
        Assert.assertEquals(1975, listWith5BooksInHandsOnLibraryUser.get(4).getPublicationYear());
        verify(libraryDatabaseMock, atMost(1)).listBooksInHandsOf(libraryUser5);
    }
}