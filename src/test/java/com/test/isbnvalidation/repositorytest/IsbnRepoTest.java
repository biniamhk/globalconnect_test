package com.test.isbnvalidation.repositorytest;

import com.test.isbnvalidation.entity.Isbn10;
import com.test.isbnvalidation.entity.Isbn13;
import com.test.isbnvalidation.repository.Isbn10Repository;
import com.test.isbnvalidation.repository.Isbn13Repository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class IsbnRepoTest {
    @Autowired
    Isbn10Repository isbn10Repository;
    @Autowired
    Isbn13Repository isbn13Repository;

    @AfterEach
    void tearDown() {
        isbn10Repository.deleteAll();
        isbn13Repository.deleteAll();
    }
    @Test
    void checkIfIsbn10IsCreated() {
        Isbn10 isbn10=new Isbn10("097470587x",true);
        isbn10Repository.save(isbn10);

       Isbn10 exist= isbn10Repository.findIsbn10ByIsbn("097470587x");
       String foundIsbn=exist.getIsbn();
        assertThat(foundIsbn).isEqualTo("097470587x");


    }
    @Test
    void checkIfIsbn13IsCreated() {
        Isbn13 isbn13=new Isbn13("9781260463415",true);
        isbn13Repository.save(isbn13);

        Isbn13 exist= isbn13Repository.findIsbn13ByIsbn("9781260463415");
        String foundIsbn=exist.getIsbn();
        assertThat(foundIsbn).isEqualTo("9781260463415");


    }
}
