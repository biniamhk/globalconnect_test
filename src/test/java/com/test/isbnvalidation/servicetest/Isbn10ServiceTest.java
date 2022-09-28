package com.test.isbnvalidation.servicetest;

import com.test.isbnvalidation.entity.Isbn10;
import com.test.isbnvalidation.entity.Isbn13;
import com.test.isbnvalidation.repository.Isbn10Repository;
import com.test.isbnvalidation.repository.Isbn13Repository;
import com.test.isbnvalidation.service.Isbn10Service;
import com.test.isbnvalidation.service.Isbn13Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class Isbn10ServiceTest {
    @Mock
    private Isbn10Repository isbn10Repository;
    @Mock
    private Isbn13Repository isbn13Repository;
    Isbn10Service isbn10ServiceTest;
    Isbn13Service isbn13ServiceTest;

    @BeforeEach
    void setUp() {
        isbn10ServiceTest = new Isbn10Service(isbn10Repository);
        isbn13ServiceTest = new Isbn13Service(isbn13Repository);
    }

    @Test
    void canGetAllIsbn10() {
        isbn10ServiceTest.findAllValidIsbn10();
        verify(isbn10Repository).findAll();
    }

    @Test
    void canGetAllIsbn13() {
        isbn13ServiceTest.findAllValidIsbn13();
        verify(isbn13Repository).findAll();
    }

    @Test
    void canValidateAndAddIsbn10() {
        Isbn10 isbn10 = new Isbn10("097470587x", true);
        isbn10ServiceTest.validateAndSaveIsbn10(isbn10);

        //then
        ArgumentCaptor<Isbn10> isbn10ArgumentCaptor = ArgumentCaptor.forClass(Isbn10.class);
        verify(isbn10Repository).save(isbn10ArgumentCaptor.capture());

        Isbn10 foundIsbn10 = isbn10ArgumentCaptor.getValue();

        assertThat(foundIsbn10).isEqualTo(isbn10);

    }

    @Test
    void canValidateAndAddIsbn13() {
        Isbn13 isbn13 = new Isbn13("9781260463415", true);

        //when
        isbn13ServiceTest.validateAndSaveIsbn13(isbn13);

        //then
        ArgumentCaptor<Isbn13> isbn13ArgumentCaptor = ArgumentCaptor.forClass(Isbn13.class);
        verify(isbn13Repository).save(isbn13ArgumentCaptor.capture());

        Isbn13 foundIsbn13 = isbn13ArgumentCaptor.getValue();

        assertThat(foundIsbn13).isEqualTo(isbn13);

    }
}
