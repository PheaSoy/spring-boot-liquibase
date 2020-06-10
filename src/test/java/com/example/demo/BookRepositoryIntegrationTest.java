package com.example.demo;


import com.example.demo.book.Book;
import com.example.demo.book.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import java.util.Optional;
@Profile("integration-test")
public class BookRepositoryIntegrationTest extends AbstractIntegrationTest{

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void saveDB(){
        bookRepository.save(new Book(1,"Title","Author",10.000));
    }
    @Test
    public void testFindByTitle(){
        Optional<Book> bookOptional = bookRepository.findBookByTitle("Title");
        Assertions.assertThat(bookOptional.isPresent()).isEqualTo(true);
    }


}
