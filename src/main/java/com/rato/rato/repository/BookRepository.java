package com.rato.rato.repository;
import com.rato.rato.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
  
}
