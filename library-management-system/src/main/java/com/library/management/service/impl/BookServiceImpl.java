package com.library.management.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.dao.BookDao;
import com.library.management.dao.BookGenreDao;
import com.library.management.dto.BookDto;
import com.library.management.exception.DataNotFoundException;
import com.library.management.repository.BookRepository;
import com.library.management.repository.GenreRepository;
import com.library.management.services.BookService;

import jakarta.transaction.Transactional;
/**
 * @author Debasish Padhy
 *
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private GenreRepository bookGenreRepository;

	@Autowired
	ModelMapper modelmap;

	Logger log = LoggerFactory.getLogger(BookService.class);

	@Transactional
	public BookDto addBook(BookDto bookDTO) {
		log.info("******** called addBook() in BookService********");
		BookGenreDao genre = bookGenreRepository.findById(bookDTO.getGenreId())
				.orElseThrow(() -> new DataNotFoundException("Genre not found in DB"));
		
		log.info("******** Genre Found********");
		BookDao bookDao = new BookDao();
		bookDao = modelmap.map(bookDTO, BookDao.class);
		bookDao.setGenre(genre);
		bookDao = bookRepository.save(bookDao);
		log.info("******** Data saved in DB ********");
		return modelmap.map(bookDao, BookDto.class);
	}

	@Transactional
	public BookDto updateBook(Long id, BookDto bookDTO) {
		log.info("******** called updateBook() in BookService********");
		BookDao bookDao = bookRepository.findById(id).
				orElseThrow(() -> new DataNotFoundException("Book not found in DB"));
		
		BookGenreDao genre = bookGenreRepository.findById(bookDTO.getGenreId())
				.orElseThrow(() -> new DataNotFoundException("Genre not found in DB"));
		log.info("******** Genre Found********");
		
		bookDao = modelmap.map(bookDTO, BookDao.class);
		bookDao.setGenre(genre);
		bookDao = bookRepository.save(bookDao);
		log.info("******** Data saved in DB ********");
		return modelmap.map(bookDao, BookDto.class);
	}

}