package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.dtos.BorrowerDTO;
import com.turkcell.spring.intro.entities.*;
import com.turkcell.spring.intro.repositories.BorrowerRepository;
import com.turkcell.spring.intro.services.abstracts.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrower")
@RequiredArgsConstructor
public class BorrowerController {
    private final BorrowerService borrowerService;
    
    @GetMapping("/getById/{id}")
    public Borrower getById(@PathVariable int id){
        return borrowerService.getById(id);
    }
    
    @PutMapping("/update")
    public void updateBorrower(@RequestBody Borrower newBorrower){
       borrowerService.update(newBorrower);
    }
    
    @DeleteMapping("/delete/{borrowerId}")
    public void deleteBorrower(@PathVariable int borrowerId) {
        borrowerService.delete(borrowerId);
    }
    
    
    @GetMapping("/getAll")
    public List<Borrower> getAll(){
        return borrowerService.getAll();
    }

    @PostMapping("/add")
    public void addBorrower(@RequestBody BorrowerDTO borrower){
        borrowerService.add(borrower);
    }
}
