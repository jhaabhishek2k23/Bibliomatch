package com.backend.bibliomatch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.bibliomatch.entities.Book;


public interface BookRepository extends JpaRepository<Book, Long> {
}