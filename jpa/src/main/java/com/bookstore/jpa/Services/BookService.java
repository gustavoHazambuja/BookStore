package com.bookstore.jpa.Services;

import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bookstore.jpa.DTOS.BookDTO;
import com.bookstore.jpa.Entities.Book;
import com.bookstore.jpa.Entities.Review;
import com.bookstore.jpa.Repositories.AuthorRepository;
import com.bookstore.jpa.Repositories.BookRepository;
import com.bookstore.jpa.Repositories.PublisherRepository;

import jakarta.transaction.Transactional;

@Service
public class BookService {
    

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Transactional
    public Book saveBook(BookDTO bookDTO){

        Book book = new Book();
        book.setTitle(bookDTO.title());
        book.setPublisher(publisherRepository.findById(bookDTO.publisherId()).get());
        book.setAuthors(authorRepository.findAllById(bookDTO.authorIds()).stream().collect(Collectors.toSet()));

        Review review = new Review();
        review.setComment(bookDTO.reviewComment());
        review.setBook(book);
        book.setReviw(review);

        return bookRepository.save(book);

    }

    @Transactional
    public Page<Book> getAllBooks(Pageable pageable){

        Page<Book> result = bookRepository.findAll(pageable);

        return result;
    }

    @Transactional
    public void deleteBook(UUID id){

        bookRepository.deleteById(id);
    }
}
