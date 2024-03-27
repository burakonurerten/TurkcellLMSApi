package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.entities.*;
import com.turkcell.spring.intro.repositories.BorrowerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrower")
@RequiredArgsConstructor
public class BorrowerController {
    private final BorrowerRepository borrowerRepository;
    
    @GetMapping("/getById/{id}")
    public ResponseEntity<Borrower> getById(@PathVariable int id){
        Borrower borrower = borrowerRepository.findById(id).orElse(null);
        
        if (borrower == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        else
            return new ResponseEntity<>(borrower, HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public Borrower updateBook(@RequestBody Borrower newBorrower){
        return new ResponseEntity<>(borrowerRepository.save(newBorrower), HttpStatus.OK).getBody();
    }
    
    @DeleteMapping("/delete/{borrowerId}")
    public void deleteBook(@PathVariable int borrowerId) {
        borrowerRepository.deleteById(borrowerId);
    }
    
    
    @GetMapping("/getAll")
    public List<Borrower> getAll(){
        return borrowerRepository.findAll();
    }

    @PostMapping("/add")
    public void addBook(@RequestBody Borrower borrower){
        borrowerRepository.save(borrower);
    }
}
