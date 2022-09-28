package com.test.isbnvalidation.service;

import com.test.isbnvalidation.entity.Isbn10;
import com.test.isbnvalidation.entity.Isbn13;
import com.test.isbnvalidation.repository.Isbn13Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Isbn13Service {
    private final Isbn13Repository isbn13Repository;

    public Isbn13Service(Isbn13Repository isbn13Repository) {
        this.isbn13Repository = isbn13Repository;
    }

    public String validateAndSaveIsbn13(Isbn13 isbn13) {
        boolean isValid;
        if (isbn13.getIsbn().length() == 13)
            isValid = validateIsbn13(isbn13.getIsbn());
        else isValid = false;
        isbn13.setValid(isValid);

        if (isbn13Repository.findIsbn13ByIsbn(isbn13.getIsbn()) != null) {
            return "Isbn13 already exist on Data Base and It is valid";
        } else if (isbn13.isValid()) {
            isbn13Repository.save(isbn13);
            return "Isbn13 is valid so it is saved on data base";
        }

        return "Isbn13 is not valid";

    }

    public Isbn13 findValidIsbn13(String isbn) {
        return isbn13Repository.findIsbn13ByIsbn(isbn);
    }

    public List<Isbn13> findAllValidIsbn13() {
        return isbn13Repository.findAll();
    }

    public Optional<Isbn13> findIsbnById(Long id) {
        return isbn13Repository.findById(id);
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

    public void deleteIsbn13(Long id) {
        isbn13Repository.deleteById(id);
    }
}
