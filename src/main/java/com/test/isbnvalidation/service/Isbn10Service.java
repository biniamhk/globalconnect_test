package com.test.isbnvalidation.service;

import com.test.isbnvalidation.repository.Isbn10Repository;

public class Isbn10Service {
    private final Isbn10Repository isbn10Repository;

    public Isbn10Service(Isbn10Repository isbn10Repository) {
        this.isbn10Repository = isbn10Repository;
    }
}
