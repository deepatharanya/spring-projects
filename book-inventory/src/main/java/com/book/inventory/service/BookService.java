package com.book.inventory.service;

import com.book.inventory.dto.BookDto;
import com.book.inventory.exception.BookNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BookService {

    private final Map<Integer, BookDto> map = new ConcurrentHashMap<>();

    private final AtomicInteger counter = new AtomicInteger(0);

    private int increment() {
        while(true) {
            int existingValue = counter.get();
            int newValue = existingValue + 1;
            if(counter.compareAndSet(existingValue, newValue)) {
                return newValue;
            }
        }
    }

    public List<BookDto> findAll() {

        return new ArrayList<>(map.values());
    }

    public BookDto findById(int id) {

        return map.get(id);
    }

    public BookDto create(BookDto book) {

        int id = increment();
        book.setId(id);

        map.put(id, book);

        return book;
    }

    public BookDto update(BookDto book) {

        validateBookId(book.getId());

        int id = null != book.getId() ? book.getId() : increment();

        map.put(id, book);

        return book;
    }

    public void deleteById(int id) {

        validateBookId(id);

        map.remove(id);
    }

    private void validateBookId(Integer id) {

        if (null == map.get(id)) {

            throw new BookNotFoundException("Unable to find a book with Id - " + id);
        }
    }
}
