package com.library.management.service.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.management.controller.GenreController;
import com.library.management.dto.BookGenreDto;
import com.library.management.service.impl.GenreServiceImpl;
/**
 * @author Debasish Padhy
 *
 */
@ExtendWith(MockitoExtension.class)
public class GenreControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GenreServiceImpl genreService;

    @InjectMocks
    private GenreController genreController;

    @Test
    public void testGetAllGenres() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(genreController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/genres/getAllGenres"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(genreService).getAllGenres();
    }

    @Test
    public void testGetBooksByGenre() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(genreController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/genres/get/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(genreService).getBooksByGenre(1L);
    }

    @Test
    public void testAddGenres() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(genreController).build();

        BookGenreDto bookGenreDto = new BookGenreDto();
        bookGenreDto.setName("Science");

        ObjectMapper objectMapper = new ObjectMapper();
        String bookGenreJson = objectMapper.writeValueAsString(bookGenreDto);

        given(genreService.addGenre(any(BookGenreDto.class))).willReturn(bookGenreDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/genres/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookGenreJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Science"));

        verify(genreService).addGenre(any(BookGenreDto.class));
    }
}
