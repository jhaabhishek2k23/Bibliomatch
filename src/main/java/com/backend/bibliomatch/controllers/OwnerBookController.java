package com.backend.bibliomatch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.bibliomatch.entities.Book;
import com.backend.bibliomatch.entities.Favourite;
import com.backend.bibliomatch.services.BookService;



@RestController
@RequestMapping("owner/section")
public class OwnerBookController {

    @Autowired
    BookService bookService;
    
    
    @PostMapping("/add")
    public ResponseEntity<?> addFavourite(@RequestBody Book requestedBook) {
        try{
            Book addedBook = bookService.addBook(requestedBook);
            return ResponseEntity.ok(addedBook);
        }catch(Exception e) {
            return ResponseEntity.status(403).body(e.getMessage());
        }
    } 


}
