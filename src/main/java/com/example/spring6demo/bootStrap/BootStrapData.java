package com.example.spring6demo.bootStrap;

import com.example.spring6demo.domain.Author;
import com.example.spring6demo.domain.Book;
import com.example.spring6demo.domain.Publisher;
import com.example.spring6demo.repository.AuthorRepository;
import com.example.spring6demo.repository.BookRepository;
import com.example.spring6demo.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@RequiredArgsConstructor
@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;


    @Override
    public void run(String... args) throws Exception {
        var lucas = Author.builder().firstName("Lucas").lastName("Dinesh").books(new ArrayList<>()).build();
        var book1 = Book.builder().title("ddd").category("TI").authors(new ArrayList<>()).build();

        var fe = Author.builder().firstName("Fernanda").lastName("Ribeiro").books(new ArrayList<>()).build();
        var book2 = Book.builder().title("PetFriendly").category("Animals").authors(new ArrayList<>()).build();

        var p1= Publisher.builder().publisherName("My publisher").city("Kansas City").books(new ArrayList<>()).build();
        var p1Saved = publisherRepository.save(p1);

        var b1Saved = bookRepository.save(book1);
        var b2Saved = bookRepository.save(book2);
        var a1Saved = authorRepository.save(lucas);
        var a2Saved = authorRepository.save(fe);

        a1Saved.getBooks().add(b1Saved);
        a2Saved.getBooks().add(b2Saved);

        b1Saved.setPublisher(p1Saved);
        p1Saved.getBooks().add(b1Saved);
        p1Saved.getBooks().add(b2Saved);

        authorRepository.save(a1Saved);
        authorRepository.save(a2Saved);

        System.out.println("BootStrapData");
        System.out.println(String.format("AuthorRepository count: %s", authorRepository.count()));
        System.out.println(String.format("BookRepository count: %s", bookRepository.count()));
        System.out.println(String.format("PublisherRepository count: %s", publisherRepository.count()));
    }
}
