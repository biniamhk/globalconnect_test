package com.test.isbnvalidation;

import com.test.isbnvalidation.entity.Isbn10;
import com.test.isbnvalidation.entity.Isbn13;
import com.test.isbnvalidation.repository.Isbn10Repository;
import com.test.isbnvalidation.repository.Isbn13Repository;
import com.test.isbnvalidation.service.Isbn10Service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IsbnValidationApplication {

    public static void main(String[] args) {
        SpringApplication.run(IsbnValidationApplication.class, args);
    }

    //sample data to be saved when the program starts
    @Bean
    public CommandLineRunner setUpSampleDataBaseGenerator(
            Isbn10Repository isbn10Repository,
            Isbn13Repository isbn13Repository) {
        return (args) -> {
            Isbn10 isbn10 = new Isbn10("0972705570",true);
            Isbn13 isbn13 = new Isbn13("9783161484100",true);

            isbn13Repository.save(isbn13);
            isbn10Repository.save(isbn10);
        };
    }
}
