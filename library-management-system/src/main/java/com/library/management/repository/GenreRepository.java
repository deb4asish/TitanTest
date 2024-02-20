package com.library.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.management.dao.BookGenreDao;
/**
 * @author Debasish Padhy
 *
 */
public interface GenreRepository extends JpaRepository<BookGenreDao, Long> {

}