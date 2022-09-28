package com.test.isbnvalidation.controller;

import com.test.isbnvalidation.entity.Isbn13;
import com.test.isbnvalidation.service.Isbn13Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("globalconnect/api/isbn13")
public class Isbn13Controller {
    private final Isbn13Service isbn13Service;

    public Isbn13Controller(Isbn13Service isbn13Service) {
        this.isbn13Service = isbn13Service;
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateAndAddIsbn13(@RequestBody Isbn13 isbn13) {
        if (isbn13.getIsbn().isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Isbn should not be null ");
        String validIsbn = isbn13Service.validateAndSaveIsbn13(isbn13);
        return new ResponseEntity<>(validIsbn, HttpStatus.CREATED);
    }

    @GetMapping("/findValidIsbn13/{isbn}")
    public ResponseEntity<Isbn13> findValidIsbn10FromDatabase(@PathVariable String isbn) {
        Isbn13 validIsbn = isbn13Service.findValidIsbn13(isbn);
        return new ResponseEntity<>(validIsbn, HttpStatus.OK);
    }

    @GetMapping("/findAllValidIsbn13")
    public ResponseEntity<List<Isbn13>> findAllValidIsbn10FromDatabase() {
        List<Isbn13> validIsbn = isbn13Service.findAllValidIsbn13();
        return new ResponseEntity<>(validIsbn, HttpStatus.OK);
    }

    @DeleteMapping("removeIsbn/{id}")
    public ResponseEntity<String> deleteIsbn13ById(@PathVariable Long id) {
        Optional<Isbn13> foundIsbn13 = isbn13Service.findIsbnById(id);
        if (foundIsbn13.isPresent()) {
            isbn13Service.deleteIsbn13(id);
            return new ResponseEntity<>("ISBN Deleted", HttpStatus.RESET_CONTENT);
        }
        return new ResponseEntity<>("ISBN  Not found", HttpStatus.RESET_CONTENT);


    }
}
