package com.test.isbnvalidation.repository;

import com.test.isbnvalidation.entity.Isbn10;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Isbn10Repository extends JpaRepository<Isbn10,Long> {
    Isbn10 findIsbn10ByIsbn(String isbn);
}
