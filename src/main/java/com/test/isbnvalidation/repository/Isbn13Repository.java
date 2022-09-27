package com.test.isbnvalidation.repository;

import com.test.isbnvalidation.entity.Isbn13;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Isbn13Repository extends JpaRepository<Isbn13,Long> {
}