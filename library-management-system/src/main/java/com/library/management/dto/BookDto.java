package com.library.management.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Debasish Padhy
 *
 */

@Getter
@Setter
public class BookDto {

	private Long id;
	
	private String title;
	
	private String author;

	private Long genreId;
}
