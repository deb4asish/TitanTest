package com.library.management.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.management.dao.BookDao;
import com.library.management.dao.BookGenreDao;
import com.library.management.dto.BookGenreDto;
import com.library.management.repository.BookRepository;
import com.library.management.repository.GenreRepository;
import com.library.management.services.GenreServices;
/**
 * @author Debasish Padhy
 *
 */
@Service
public class GenreServiceImpl implements GenreServices{
	
	@Autowired
    private GenreRepository genreRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private ModelMapper modelmap;

	@Transactional
    public BookGenreDto addGenre(BookGenreDto genreDTO) {
    	BookGenreDao genre = new BookGenreDao();
    	
    	genre =	modelmap.map(genreDTO, BookGenreDao.class);
    	genre = genreRepository.save(genre);
        return modelmap.map(genre, BookGenreDto.class);
    }

	@Transactional(readOnly = true)
    public List<BookGenreDao> getAllGenres() {
        return genreRepository.findAll();
    }

	@Transactional(readOnly = true)
    public List<BookDao> getBooksByGenre(Long genreId) {
        return bookRepository.findByGenreId(genreId);
    }
}