package com.bookstore.jpa.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookstore.jpa.Entities.Book;
import java.util.List;


public interface BookRepository extends JpaRepository<Book, UUID> {
    
    Book findBookByTitle(String title);

    @Query(value = "SELECT * FROM tb_book WHERE publisher_id = :id", nativeQuery = true)
    List<Book> findBookByPublisherId(@Param("id") UUID id);
}
