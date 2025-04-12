package com.backend.bibliomatch.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.bibliomatch.entities.BorrowedBook;
import com.backend.bibliomatch.services.BorrowedBookService;



@RestController
@RequestMapping("/borrowed-books")
public class BorrowedBookController {

    @Autowired
    private BorrowedBookService borrowedBookService;

    @PostMapping("/add")
    public BorrowedBook addBorrowedBook(@RequestParam Long userId, @RequestParam Long bookId) {
        return borrowedBookService.addBorrowedBook(userId, bookId);
    }

    @GetMapping("/testBorrow")
    public String testBorrow(@RequestParam String param) {
        return new String("TEST BORROW DUDE");
    }
    

    @PutMapping("/mark-borrowed/{borrowedBookId}")
    public void markAsBorrowed(@PathVariable Long borrowedBookId, @RequestParam Long borrowedByUserId) {
        borrowedBookService.markAsBorrowed(borrowedBookId, borrowedByUserId);
    }

    @DeleteMapping("/remove/{borrowedBookId}")
    public void removeBorrowedBook(@PathVariable Long borrowedBookId) {
        borrowedBookService.removeBorrowedBook(borrowedBookId);
    }

    @GetMapping("/user/{userId}")
    public List<BorrowedBook> getBorrowedBooksByUserId(@PathVariable Long userId) {
        return borrowedBookService.getBorrowedBooksByUserId(userId);
    }
}