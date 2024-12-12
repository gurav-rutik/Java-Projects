package com.library.management.data;

import com.library.management.entity.Book;

//LibraryData.java


public interface LibraryData {
 void add(Book book);
 void update(int id, Book updatedBook);
 void delete(int id);
 Book findByTitle(String title);
 Book findByAuthor(String author);
 Book findByGenre(String genre);
 Book findById(int id);
 Book[] getAllBooks(); // Returns an array of all books
}
