package com.test.isbnvalidation.controller;

import com.test.isbnvalidation.entity.Isbn13;
import com.test.isbnvalidation.exception.BadRequestException;

import com.test.isbnvalidation.service.Isbn13Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("globalconnect/api/isbn13")
public class Isbn13Controller {
    private final Isbn13Service isbn13Service;

    public Isbn13Controller(Isbn13Service isbn13Service) {
        this.isbn13Service = isbn13Service;
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validateAndAddIsbn10(@RequestBody Isbn13 isbn13) {
       Isbn13 validIsbn = isbn13Service.validateAndSaveIsbn13(isbn13);
        return new ResponseEntity<>(validIsbn, HttpStatus.CREATED);


    }
}
