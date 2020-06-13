package com.example.demo.book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private BookRepository bookRepository;
    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping("book/{id}")
    private Book getBookById(@PathVariable("id") int id){
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }
}
