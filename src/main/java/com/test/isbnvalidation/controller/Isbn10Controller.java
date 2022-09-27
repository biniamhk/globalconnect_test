package com.test.isbnvalidation.controller;

import com.test.isbnvalidation.entity.Isbn10;
import com.test.isbnvalidation.exception.BadRequestException;
import com.test.isbnvalidation.service.Isbn10Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("globalconnect/api/isbn10")
public class Isbn10Controller {
    private final Isbn10Service isbn10Service;

    public Isbn10Controller(Isbn10Service isbn10Service) {
        this.isbn10Service = isbn10Service;
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateAndAddIsbn10(@RequestBody Isbn10 isbn10) {
        if (isbn10.getIsbn().isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Isbn should not be null ");
        String valid = isbn10Service.validateAndSaveIsbn10(isbn10);

        return new ResponseEntity<>(valid, HttpStatus.OK);
    }

    @GetMapping("/findValidIsbn10/{isbn}")
    public ResponseEntity<Isbn10> findValidIsbn10FromDatabase(@PathVariable String isbn) {
        Isbn10 validIsbn = isbn10Service.findValidIsbn10(isbn);
        return new ResponseEntity<>(validIsbn, HttpStatus.OK);
    }

    @GetMapping("/findAllValidIsbn10")
    public ResponseEntity<List<Isbn10>> findAllValidIsbn10FromDatabase() {
        List<Isbn10> validIsbn = isbn10Service.findAllValidIsbn10();
        return new ResponseEntity<>(validIsbn, HttpStatus.OK);
    }

    @DeleteMapping("removeIsbn/{id}")
    public ResponseEntity<String> deleteIsbn10ById(@PathVariable Long id) {
        Optional<Isbn10> foundIsbn10 = isbn10Service.findIsbnById(id);
        if(foundIsbn10.isPresent())
        return new ResponseEntity<>("ISBN Deleted",HttpStatus.RESET_CONTENT);

        return new ResponseEntity<>("ISBN  Not found",HttpStatus.RESET_CONTENT);


    }

}
