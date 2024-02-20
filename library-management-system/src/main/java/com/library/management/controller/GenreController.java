package com.library.management.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.dao.BookDao;
import com.library.management.dao.BookGenreDao;
import com.library.management.dto.BookGenreDto;
import com.library.management.service.impl.GenreServiceImpl;
/**
 * @author Debasish Padhy
 *
 */
@RestController
@RequestMapping("/api/genres")
public class GenreController {

    
    @Autowired
    private GenreServiceImpl genService;
    
    @GetMapping("/getAllGenres")
    public ResponseEntity<List<BookGenreDao>> getAllGenres() {
        List<BookGenreDao> genres = genService.getAllGenres();
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }
    
    @GetMapping("/get/{genreId}")
    public ResponseEntity<List<BookDao>> getBooksByGenre(@PathVariable Long genreId) {
        List<BookDao> books = genService.getBooksByGenre(genreId);
        return ResponseEntity.ok(books);
    }
    
    @PostMapping("/add")
    public ResponseEntity<BookGenreDto> addGenres(@RequestBody BookGenreDto book){
    	
    	BookGenreDto bookgenrDao =  genService.addGenre(book);
    	return ResponseEntity.ok(bookgenrDao);
    }
}
