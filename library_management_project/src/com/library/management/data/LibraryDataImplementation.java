package com.library.management.data;

import com.library.management.entity.Book;

//LibraryDataImplementation.java

public class LibraryDataImplementation implements LibraryData {

 private Book[] books = new Book[10];
 private int index = 0;

 @Override
 public void add(Book book) {
     if (index == books.length) {
         expandCapacity();
     }
     books[index++] = book;
 }

 @Override
 public void update(int id, Book updatedBook) {
     for (int i = 0; i < index; i++) {
         if (books[i].getId() == id) {
             books[i] = updatedBook;
             break;
         }
     }
 }

 @Override
 public void delete(int id) {
     for (int i = 0; i < index; i++) {
         if (books[i].getId() == id) {
             books[i] = null;
             normalizeArray(i);
             break;
         }
     }
 }

 @Override
 public Book findByTitle(String title) {
     for (int i = 0; i < index; i++) {
         if (books[i].getTitle().equalsIgnoreCase(title)) {
             return books[i];
         }
     }
     return null;
 }

 @Override
 public Book findByAuthor(String author) {
     for (int i = 0; i < index; i++) {
         if (books[i].getAuthor().equalsIgnoreCase(author)) {
             return books[i];
         }
     }
     return null;
 }

 @Override
 public Book findByGenre(String genre) {
     for (int i = 0; i < index; i++) {
         if (books[i].getGenre().equalsIgnoreCase(genre)) {
             return books[i];
         }
     }
     return null;
 }

 @Override
 public Book findById(int id) {
     for (int i = 0; i < index; i++) {
         if (books[i].getId() == id) {
             return books[i];
         }
     }
     return null;
 }

 @Override
 public Book[] getAllBooks() {
     Book[] allBooks = new Book[index];
     for (int i = 0; i < index; i++) {
         allBooks[i] = books[i];
     }
     return allBooks;
 }

 private void expandCapacity() {
     Book[] temp = new Book[books.length * 2];
     for (int i = 0; i < index; i++) {
         temp[i] = books[i];
     }
     books = temp;
 }

 private void normalizeArray(int pos) {
     for (int i = pos; i < index - 1; i++) {
         books[i] = books[i + 1];
     }
     index--;
 }
}
