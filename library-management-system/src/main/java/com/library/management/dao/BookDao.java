package com.library.management.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * @author Debasish Padhy
 *
 */
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book_details")
public class BookDao {

	@Id
	@Column(name = "book_id")
	private Long id;

	@Column(name = "book_title")
	private String title;

	@Column(name = "book_author")
	private String author;

	@ManyToOne
	@JoinColumn(name = "genre_id")
	@JsonIgnore
	private BookGenreDao genre;

}
