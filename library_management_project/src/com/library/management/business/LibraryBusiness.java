// LibraryBusiness.java
package com.library.management.business;

public interface LibraryBusiness {
    void addBook();
    void updateBook();
    void deleteBook();
    void restoreBook();
    void searchByTitle();
    void searchByAuthor();
    void searchByGenre();
    void borrowBook();
    void returnBook();
    void showAllBooks();  // New method to show all books
}
