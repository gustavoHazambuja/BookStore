package com.bookstore.jpa.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.jpa.Entities.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, UUID> {
    
}
