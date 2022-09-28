package com.test.isbnvalidation.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Isbn10 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String isbn;
    private boolean valid;

    public Isbn10(String isbn) {
        this.isbn=isbn;
    }
}
