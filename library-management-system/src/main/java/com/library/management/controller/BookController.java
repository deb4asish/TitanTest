package com.library.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.dto.BookDto;
import com.library.management.service.impl.BookServiceImpl;

/**
 * @author Debasish Padhy
 *
 */

@RestController
@RequestMapping("/api/books")
public class BookController {
    
    @Autowired
    private BookServiceImpl bookService;
    
    Logger log = LoggerFactory.getLogger(BookController.class);
    
    @PostMapping("/add")
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto book) {
    	log.info("*******Inserted to /add API**********");
        BookDto addedBook = bookService.addBook(book);
       return new ResponseEntity<>(addedBook, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable("id") Long bookId, @RequestBody BookDto updatedBook) {
    	log.info("*******Inserted to /update/{id} API**********");
    	BookDto updated = bookService.updateBook(bookId, updatedBook);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    
    
}
