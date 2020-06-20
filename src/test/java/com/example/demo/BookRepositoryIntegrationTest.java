package com.example.demo;


import com.example.demo.book.Book;
import com.example.demo.book.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Optional;
@Profile("integration-test")
@SpringBootTest

public class BookRepositoryIntegrationTest{

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>()
            .withUsername("user")
            .withPassword("password")
            .withDatabaseName("test_db");

    @DynamicPropertySource
    static void postgresqlProperties(DynamicPropertyRegistry registry) {
        postgres.start();
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
        registry.add("spring.liquibase.contexts", () -> "!prod");
    }

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void saveDB(){
        bookRepository.save(new Book(2,"Title","Author",10.000));
    }

    @Test
    public void testFindByTitle(){
        Optional<Book> bookOptional = bookRepository.findBookByTitle("Title");
        Assertions.assertThat(bookOptional.isPresent()).isEqualTo(true);
    }
    @Test
    @DisplayName("Test find book by id from liquibase initialised")
    public void find_book_by_id(){
        Optional<Book> bookOptional = bookRepository.findById(2);
        Assertions.assertThat(bookOptional.isPresent()).isEqualTo(true);
    }


    @Test
    @DisplayName("Test liquibase context prod should not execute ")
    public void find_book_by_id_context_prod(){
        Optional<Book> bookOptional = bookRepository.findById(10);
        Assertions.assertThat(bookOptional.isPresent()).isEqualTo(false);
    }
}
