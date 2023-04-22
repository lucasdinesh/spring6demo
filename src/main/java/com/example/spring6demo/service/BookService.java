package com.example.spring6demo.service;

import com.example.spring6demo.domain.Book;
import com.example.spring6demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAll(){
        return (List<Book>) bookRepository.findAll();
    }
}
