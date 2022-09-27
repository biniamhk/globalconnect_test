package com.test.isbnvalidation.repository;

import com.test.isbnvalidation.entity.Isbn10;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Isbn10Repository extends JpaRepository<Isbn10,Long> {
}
