// LibraryBusinessImplementation.java
package com.library.management.business;

import java.util.Scanner;

import com.library.management.data.LibraryData;
import com.library.management.data.LibraryDataImplementation;
import com.library.management.entity.Book;

public class LibraryBusinessImplementation implements LibraryBusiness {

    private LibraryData data = new LibraryDataImplementation();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void addBook() {
        System.out.println("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.println("Enter Book Author: ");
        String author = scanner.nextLine();
        System.out.println("Enter Book Genre: ");
        String genre = scanner.nextLine();
        Book book = new Book(id, title, author, genre);
        data.add(book);
        System.out.println("Book added successfully!");
    }

    @Override
    public void updateBook() {
        System.out.println("Enter Book ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Book book = data.findById(id);
        if (book != null) {
            System.out.println("Enter New Title: ");
            String title = scanner.nextLine();
            System.out.println("Enter New Author: ");
            String author = scanner.nextLine();
            System.out.println("Enter New Genre: ");
            String genre = scanner.nextLine();
            Book updatedBook = new Book(id, title, author, genre);
            data.update(id, updatedBook);
            System.out.println("Book updated successfully!");
        } else {
            System.out.println("Book not found.");
        }
    }

    @Override
    public void deleteBook() {
        System.out.println("Enter Book ID to delete: ");
        int id = scanner.nextInt();
        data.delete(id);
        System.out.println("Book deleted successfully!");
    }

    @Override
    public void restoreBook() {
        // Implement restoration logic if needed
    }

    @Override
    public void searchByTitle() {
        System.out.println("Enter Book Title to search: ");
        String title = scanner.next();
        Book book = data.findByTitle(title);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }
    }

    @Override
    public void searchByAuthor() {
        System.out.println("Enter Book Author to search: ");
        String author = scanner.next();
        Book book = data.findByAuthor(author);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }
    }

    @Override
    public void searchByGenre() {
        System.out.println("Enter Book Genre to search: ");
        String genre = scanner.next();
        Book book = data.findByGenre(genre);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }
    }

    @Override
    public void borrowBook() {
        System.out.println("Enter Book ID to borrow: ");
        int id = scanner.nextInt();
        Book book = data.findById(id);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book is not available.");
        }
    }

    @Override
    public void returnBook() {
        System.out.println("Enter Book ID to return: ");
        int id = scanner.nextInt();
        Book book = data.findById(id);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book is already available.");
        }
    }

    @Override
    public void showAllBooks() {
        Book[] allBooks = data.getAllBooks();
        if (allBooks.length == 0) {
            System.out.println("No books available.");
        } else {
            System.out.println("All Available Books:");
            for (Book book : allBooks) {
                if (book != null) {
                    System.out.println(book);
                }
            }
        }
    }
}
