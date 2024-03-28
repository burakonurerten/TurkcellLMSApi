package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.dtos.BookDTO;
import com.turkcell.spring.intro.entities.Book;
import com.turkcell.spring.intro.repositories.BookRepository;
import com.turkcell.spring.intro.services.abstracts.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/getById/{id}")
    public Book getById(@PathVariable int id){
        return bookService.getById(id);
    }
    
    @PutMapping("/update")
    public void updateBook(@RequestBody Book newBook){
        bookService.update(newBook);
    }
    
    @DeleteMapping("/delete/{bookId}")
    public void deleteBook(@PathVariable int bookId) {
        bookService.delete(bookId);
    }
    
    @GetMapping("/getAll")
    public List<Book> getAll(){
        return bookService.getAll();
    }

    @PostMapping("/add")
    public void addBook(@RequestBody BookDTO book){
        bookService.add(book);
    }
}
