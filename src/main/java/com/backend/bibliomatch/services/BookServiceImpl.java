package com.backend.bibliomatch.services;

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
    
}
