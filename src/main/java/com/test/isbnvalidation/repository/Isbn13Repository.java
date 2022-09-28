package com.test.isbnvalidation.repository;

import com.test.isbnvalidation.entity.Isbn10;
import com.test.isbnvalidation.entity.Isbn13;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Isbn13Repository extends JpaRepository<Isbn13,Long> {
    Isbn13 findIsbn13ByIsbn(String isbn);
}
