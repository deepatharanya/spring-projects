package com.book.inventory.controller;

import com.book.inventory.dto.BookDto;
import com.book.inventory.exception.BookIdMismatchException;
import com.book.inventory.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDto> findAll() {

        return bookService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto create(@RequestBody BookDto book) {

        return bookService.create(book);
    }

    @GetMapping("/{id}")
    public BookDto findOne(@PathVariable int id) {

        return bookService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {

        bookService.deleteById(id);
    }

    @PutMapping("/{id}")
    public BookDto updateBook(@RequestBody BookDto book, @PathVariable int id) {

        if (book.getId() != id) {
            throw new BookIdMismatchException("Resource Id did not match with book Id");
        }

        return bookService.update(book);
    }
}
