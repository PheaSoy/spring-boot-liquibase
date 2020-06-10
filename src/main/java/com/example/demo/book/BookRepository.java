package com.example.demo.book;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book,Integer> {

    Optional<Book> findBookByTitle(String title);
}
