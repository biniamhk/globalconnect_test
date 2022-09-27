package com.test.isbnvalidation.service;

import com.test.isbnvalidation.repository.Isbn10Repository;

public class Isbn13Service {
    private final Isbn10Repository isbn13Repository;

    public Isbn13Service(Isbn10Repository isbn10Repository) {
        this.isbn13Repository = isbn10Repository;
    }
}
