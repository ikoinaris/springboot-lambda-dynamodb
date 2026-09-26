package com.tutorial.service;

import com.tutorial.entity.Book;
import com.tutorial.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void save(Book book) {
        book.setId(UUID.randomUUID().toString());
        bookRepository.save(book);
    }

    public Book findById(String id) {
        return bookRepository.findById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void deleteById(String id) {
        bookRepository.deleteById(id);
    }
}
