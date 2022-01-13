package com.rato.rato.controller;

import com.rato.rato.repository.BookRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
  
  private BookRepository bookRepository;
  
}
