package com.test.isbnvalidation.service;

import com.test.isbnvalidation.entity.Isbn10;
import com.test.isbnvalidation.repository.Isbn10Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Isbn10Service {
    private final Isbn10Repository isbn10Repository;

    public Isbn10Service(Isbn10Repository isbn10Repository) {
        this.isbn10Repository = isbn10Repository;
    }

    public String validateAndSaveIsbn10(Isbn10 isbn10) {
        boolean isValid;
        if (isbn10.getIsbn().length() == 10)
            isValid = validateIsbn10(isbn10.getIsbn());
        else isValid = false;

        isbn10.setValid(isValid);
        if (isbn10Repository.findIsbn10ByIsbn(isbn10.getIsbn()) != null) {
            return "Isbn10 already exist on Data Base and It is valid";
        } else if (isbn10.isValid()) {
            isbn10Repository.save(isbn10);
            return "Isbn10 is valid so it is saved on data base";
        }

        return "Isbn10 is not valid";
    }

    public Isbn10 findValidIsbn10(String isbn) {
        return isbn10Repository.findIsbn10ByIsbn(isbn);
    }

    private static boolean validateIsbn10(String isbn10) {
        int sum = 0;

        for (int i = 0; i < isbn10.length(); i++) {
            String charAtPosition = isbn10.substring(i, i + 1);
            //if the last digit is not "X"
            if (i < 9 || !charAtPosition.equalsIgnoreCase("X")) {
                sum += Integer.parseInt(charAtPosition) * (10 - i);
            }
            //if last digit is "X"
            else
                sum += 10;

        }
        //return true or false depending on the reminder
        return (sum % 11 == 0);
    }

    public List<Isbn10> findAllValidIsbn10() {
        return isbn10Repository.findAll();
    }

    public Optional<Isbn10> findIsbnById(Long id) {
        return isbn10Repository.findById(id);
    }

    public void deleteById(Long id) {
        isbn10Repository.deleteById(id);
    }
}
