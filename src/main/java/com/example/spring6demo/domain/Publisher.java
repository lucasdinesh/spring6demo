package com.example.spring6demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String publisherName;
    private String address;
    private String city;
    private String zipcode;
    private String state;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;
}
