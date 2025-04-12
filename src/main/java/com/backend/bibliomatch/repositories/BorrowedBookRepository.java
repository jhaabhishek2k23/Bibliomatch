package com.backend.bibliomatch.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.bibliomatch.entities.BorrowedBook;


public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
    List<BorrowedBook> findByUserId(Long userId);
}