package com.example.obrestdatajpa;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
//        BookRepository repository = context.getBean(BookRepository.class);

    }

}
