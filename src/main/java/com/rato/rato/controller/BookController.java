package com.rato.rato.controller;

import com.rato.rato.repository.BookRepository;
import com.rato.rato.entity.Book;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
  
  private BookRepository repository;

  @Autowired
  public BookController(BookRepository bookRepository){
    this.repository = bookRepository;
  }
  
  // CRUD methods here
  @GetMapping
  public List findAll(){
    return repository.findAll();
  }

  @GetMapping(path = {"/{id}"})
  public ResponseEntity<Book> findById(@PathVariable long id){
    return repository.findById(id)
            .map(record -> ResponseEntity.ok().body(record))
            .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Book create(@RequestBody Book instance){
      return repository.save(instance);
  }

  @PutMapping(value="/{id}")
  public ResponseEntity<Book> update(@PathVariable("id") long id,
                                        @RequestBody Book instance){
    return repository.findById(id)
        .map(record -> {
            record.setName(instance.getName());
            record.setChapter(instance.getChapter());


            //record.setName(instance.getName());
            //record.setPhone (contact.getPhone());
            //record.setPhone(contact.getPhone());
            Book updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping(path ={"/{id}"})
  public ResponseEntity<?> delete(@PathVariable("id") long id) {
    return repository.findById(id)
        .map(record -> {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
  }

  
}
