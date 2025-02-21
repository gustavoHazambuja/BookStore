package com.bookstore.jpa.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.jpa.Entities.Author;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
    
}
