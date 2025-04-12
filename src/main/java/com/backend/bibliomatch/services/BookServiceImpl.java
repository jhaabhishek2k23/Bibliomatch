package com.backend.bibliomatch.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.bibliomatch.entities.Book;
import com.backend.bibliomatch.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService{


    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book addBook(Book currBookDetails) {

        return bookRepository.save(currBookDetails);
    }

    @Override
    public void removeBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllOwnedBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void updateOwnedBook(Long id, Book book) {
       bookRepository.updateOwnedBook(id,book);
    }
    
}
