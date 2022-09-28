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
public class Isbn13 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String isbn;
    private boolean valid;

    public Isbn13(String isbn, boolean valid) {
        this.isbn = isbn;
        this.valid = valid;
    }
}

