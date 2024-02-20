package com.library.management.services;

import java.util.List;

import com.library.management.dao.BookDao;
import com.library.management.dao.BookGenreDao;
import com.library.management.dto.BookGenreDto;
/**
 * @author Debasish Padhy
 *
 */
public interface GenreServices {

	public BookGenreDto addGenre(BookGenreDto genreDTO);

	public List<BookGenreDao> getAllGenres();

	public List<BookDao> getBooksByGenre(Long genreId);
}
