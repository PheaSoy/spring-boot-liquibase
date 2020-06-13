package com.example.demo;

import com.example.demo.book.Book;
import com.example.demo.book.BookController;
import com.example.demo.book.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void testBookController_expect_ok() throws Exception {
        when(bookRepository.findById(any())).thenReturn(Optional.of(new Book(1, "OK", "OK?", 100.0)));
        mockMvc.perform(get("/book/1")).andExpect(status().isOk());
    }


}
