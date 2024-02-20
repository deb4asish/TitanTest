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
import com.library.management.controller.BookController;
import com.library.management.dto.BookDto;
import com.library.management.service.impl.BookServiceImpl;

/**
 * @author Debasish Padhy
 *
 */

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
	
    private MockMvc mockMvc;

    @Mock
    private BookServiceImpl bookService;

    @InjectMocks
    private BookController bookController;

    @Test
    public void testAddBook() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();

        BookDto bookDto = new BookDto();
        bookDto.setTitle("Legend");
        bookDto.setAuthor("Debasish Padhy");

        ObjectMapper objectMapper = new ObjectMapper();
        String bookJson = objectMapper.writeValueAsString(bookDto);

        given(bookService.addBook(any(BookDto.class))).willReturn(bookDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/books/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookJson))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Legend"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("Debasish Padhy"));

        verify(bookService).addBook(any(BookDto.class));
    }

    @Test
    public void testUpdateBook() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();

        BookDto updatedBookDto = new BookDto();
        updatedBookDto.setTitle("Biology");
        updatedBookDto.setAuthor("Debasish Padhy");

        ObjectMapper objectMapper = new ObjectMapper();
        String updatedBookJson = objectMapper.writeValueAsString(updatedBookDto);

        given(bookService.updateBook(any(Long.class), any(BookDto.class))).willReturn(updatedBookDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/books/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedBookJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Biology"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("Debasish Padhy"));

        verify(bookService).updateBook(any(Long.class), any(BookDto.class));
    }
}
