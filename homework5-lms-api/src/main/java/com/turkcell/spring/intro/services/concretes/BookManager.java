package com.turkcell.spring.intro.services.concretes;

import java.util.List;
import org.springframework.stereotype.Service;
import com.turkcell.spring.intro.dtos.BookDTO;
import com.turkcell.spring.intro.entities.*;
import com.turkcell.spring.intro.repositories.*;
import com.turkcell.spring.intro.services.abstracts.BookService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookManager implements BookService {
    private final BookRepository bookRepository;
    
    @Override
    public void add(BookDTO bookDTO) {
        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsAvailable(bookDTO.isAvailable());
        book.setBorrowDate(bookDTO.getBorrowDate());
        book.setReturnDate(bookDTO.getReturnDate());
        bookRepository.save(book);
    }
    
    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }
    
    @Override
    public void delete(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book == null)
            throw new RuntimeException("There is no book with this id: " + id);
        bookRepository.delete(book);
    }
    
    @Override
    public Book getById(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        
        if(book == null)
            throw new RuntimeException("There is no book with this id: " + id);
        
        return book;
    }
    
    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
