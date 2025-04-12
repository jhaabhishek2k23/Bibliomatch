package com.backend.bibliomatch.services;

import java.util.List;

import com.backend.bibliomatch.entities.Book;



public interface BookService {
    public Book addBook(Book currBookDetails);
    public void removeBook(Long id);
    public List<Book> getAllOwnedBooks();
    public void updateOwnedBook(Long id, Book book);
}
