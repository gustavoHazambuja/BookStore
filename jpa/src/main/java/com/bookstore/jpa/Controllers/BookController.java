package com.bookstore.jpa.Controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.jpa.DTOS.BookDTO;
import com.bookstore.jpa.Entities.Book;
import com.bookstore.jpa.Services.BookService;

@RestController
@RequestMapping(value = "/bookstore/books")
public class BookController {
    
    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody BookDTO bookDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(bookDTO));
        
    }

    @GetMapping
    public ResponseEntity<Page<Book>> getAllBooks(Pageable pageable){

        Page<Book> result = bookService.getAllBooks(pageable);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable UUID id){

        bookService.deleteBook(id);

        return ResponseEntity.status(HttpStatus.OK).body("Book deleted sucessfully.");
    }
}
