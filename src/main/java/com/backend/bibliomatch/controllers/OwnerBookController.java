package com.backend.bibliomatch.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.bibliomatch.entities.Book;

import com.backend.bibliomatch.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;






@RestController
@RequestMapping("owner/section")
public class OwnerBookController {

    @Autowired
    BookService bookService;
    
    
    @PostMapping("/add")
    public ResponseEntity<?> ownerAddingBooks(@RequestBody Book requestedBook) {
        try{
            Book addedBook = bookService.addBook(requestedBook);
            return ResponseEntity.ok(addedBook);
        }catch(Exception e) {
            return ResponseEntity.status(403).body(e.getMessage());
        }
    } 

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeAddedBook(@RequestParam Long id) {
        try{
            bookService.removeBook(id);
            return ResponseEntity.ok("book has been removed bro");
        }catch(Exception e) {
            return ResponseEntity.status(403).body(e.getMessage());
        }
    }

    @GetMapping("/allOwnedBooks")
    public ResponseEntity<?> getMethodName() {
        try{

            List<Book> ownedBooks = bookService.getAllOwnedBooks();
            return ResponseEntity.ok(ownedBooks);

        }catch(Exception e) {
            return ResponseEntity.status(403).body(e.getMessage());
        }
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable Long id, @RequestBody Book book) {
        try{
            bookService.updateOwnedBook(id, book);
            return ResponseEntity.ok("Book with id "+ id + "has been updated..");
        }catch(Exception e) {
            return ResponseEntity.status(403).body(e.getMessage());
        }
    }
    
    


}
