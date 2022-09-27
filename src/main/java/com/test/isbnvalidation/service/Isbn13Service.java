package com.test.isbnvalidation.service;

import com.test.isbnvalidation.entity.Isbn13;
import com.test.isbnvalidation.repository.Isbn13Repository;
import org.springframework.stereotype.Service;

@Service
public class Isbn13Service {
    private final Isbn13Repository isbn13Repository;

    public Isbn13Service(Isbn13Repository isbn13Repository) {
        this.isbn13Repository = isbn13Repository;
    }

    public Isbn13 validateAndSaveIsbn13(Isbn13 isbn13) {
        boolean isValid;
        if (isbn13.getIsbn().length() == 13)
            isValid = validateIsbn13(isbn13.getIsbn());

        else isValid = false;


        isbn13.setValid(isValid);
        return isbn13Repository.save(isbn13);
    }

    private boolean validateIsbn13(String isbn13) {
        int sum = 0;
        for (int i = 0; i < isbn13.length(); i++) {
            int numberAtPosition = Integer.parseInt(String.valueOf(isbn13.charAt(i)));
            if (i % 2 == 0) {
                sum += numberAtPosition;
            } else {
                sum += numberAtPosition * 3;
            }

        }
        return (sum % 10 == 0);
    }
}
