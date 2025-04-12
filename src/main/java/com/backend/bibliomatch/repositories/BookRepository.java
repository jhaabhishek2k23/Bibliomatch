package com.backend.bibliomatch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.backend.bibliomatch.entities.Book;

import jakarta.transaction.Transactional;


public interface BookRepository extends JpaRepository<Book, Long> {

    @Transactional
    default Book updateOwnedBook(Long id, Book bookUpdates) {
        Book existingBook = findById(id)
            .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        // Only update fields that are explicitly set in bookUpdates
        if (bookUpdates.getTitle() != null) {
            existingBook.setTitle(bookUpdates.getTitle());
        }
        if (bookUpdates.getAuthor() != null) {
            existingBook.setAuthor(bookUpdates.getAuthor());
        }
        if (bookUpdates.getGenre() != null) {
            existingBook.setGenre(bookUpdates.getGenre());
        }
        if (bookUpdates.getDescription() != null) {
            existingBook.setDescription(bookUpdates.getDescription());
        }
        // For primitive boolean, we need to check if it was explicitly set
        // (This assumes you have a way to track if isAvailable was set)
        
        return save(existingBook);
    }


}