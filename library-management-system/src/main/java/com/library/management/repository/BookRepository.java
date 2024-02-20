package com.library.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.management.dao.BookDao;
/**
 * @author Debasish Padhy
 *
 */
public interface BookRepository extends JpaRepository<BookDao, Long> {

	//@Query(value = "Select * from book_genre where book_genre.id = ?1",nativeQuery = true)
	List<BookDao> findByGenreId(Long genreId);
}

