package com.library.management.services;

import com.library.management.dto.BookDto;
/**
 * @author Debasish Padhy
 *
 */
public interface BookService {

	public BookDto addBook(BookDto bookDTO);

	public BookDto updateBook(Long id, BookDto bookDTO);
}
