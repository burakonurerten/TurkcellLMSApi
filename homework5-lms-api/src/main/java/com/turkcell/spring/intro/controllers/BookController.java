package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.entities.Book;
import com.turkcell.spring.intro.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping("/getById/{id}")
    public ResponseEntity<Book> getById(@PathVariable int id){
        Book book = bookRepository.findById(id).orElse(null);
    
        if (book == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        else
            return new ResponseEntity<>(book, HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public Book updateBook(@RequestBody Book newBook){
        return new ResponseEntity<>(bookRepository.save(newBook), HttpStatus.OK).getBody();
    }
    
    @DeleteMapping("/delete/{bookId}")
    public void deleteBook(@PathVariable int bookId) {
        bookRepository.deleteById(bookId);
    }
    
    @GetMapping("/getAll")
    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    @PostMapping("/add")
    public void addBook(@RequestBody Book book){
        bookRepository.save(book);
    }
}
