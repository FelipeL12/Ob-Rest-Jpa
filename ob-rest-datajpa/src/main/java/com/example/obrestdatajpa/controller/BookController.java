package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);
    private BookRepository bookRepository;

//    CONSTRUCTOR

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //    CREAR UN LIBRO
    @ApiOperation("Crear un libro")
    @PostMapping("/api/books")
    public ResponseEntity<Book> create(@ApiParam("entidad de tipo book") @RequestBody Book book) {

        if (book.getId() != null) {
            log.warn("Trying to creat book with id");
            return ResponseEntity.badRequest().build();
        }
        Book bookSaved = bookRepository.save(book);
        return ResponseEntity.ok(bookSaved);
    }

    //    MOSTRAR TODOS LOS LIBROS

    @GetMapping("/api/books")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    //    MOSTRAR UN LIBRO POR SU ID

    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findByID(@PathVariable("id") Integer id) {

        Optional<Book> bookOpt = bookRepository.findById(id);
        if (bookOpt.isPresent())
            return ResponseEntity.ok(bookOpt.get());
        else
            return ResponseEntity.notFound().build();
    }

//    ACTULIZAR UN LIBRO POR SU ID

    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book) {
        if (book.getId() == null) {
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }

        if (!bookRepository.existsById(book.getId())) {
            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build();
        }

        Book updatedBook = bookRepository.save(book);
        return ResponseEntity.ok(updatedBook);
    }

//    ELIMINAR UN LIBRO POR SU ID

    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable("id") Integer id) {
        if (id == null) {
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.notFound().build();
        }

        if (!bookRepository.existsById(id)) {
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.badRequest().build();
        }

        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

//    ELIMINAR TODOS LOS LIBROS

    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll() {
        if (bookRepository.count() <= 0) {
            log.warn("Trying to delete non existent book");
            return ResponseEntity.notFound().build();
        }

        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
