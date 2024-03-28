package com.turkcell.spring.intro.services.concretes;

import java.util.List;
import org.springframework.stereotype.Service;
import com.turkcell.spring.intro.dtos.BorrowerDTO;
import com.turkcell.spring.intro.entities.*;
import com.turkcell.spring.intro.repositories.*;
import com.turkcell.spring.intro.services.abstracts.BorrowerService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BorrowerManager implements BorrowerService {
    private final BorrowerRepository borrowerRepository;
    
    @Override
    public void add(BorrowerDTO borrowerDTO) {
        Borrower borrower = new Borrower();
        borrower.setName(borrowerDTO.getName());
        borrower.setEmail(borrowerDTO.getEmail());
        borrower.setPhoneNumber(borrowerDTO.getPhoneNumber());
        borrowerRepository.save(borrower);
    }
    
    @Override
    public void update(Borrower borrower) {
        borrowerRepository.save(borrower);
    }
    
    @Override
    public void delete(int id) {
        Borrower borrower = borrowerRepository.findById(id).orElse(null);
        if(borrower == null)
            throw new RuntimeException("There is no borrower with this id: " + id);
        borrowerRepository.delete(borrower);
    }
    
    @Override
    public Borrower getById(int id) {
        Borrower borrower = borrowerRepository.findById(id).orElse(null);
        
        if(borrower == null)
            throw new RuntimeException("There is no borrower with this id: " + id);
        
        return borrower;
    }
    
    @Override
    public List<Borrower> getAll() {
        return borrowerRepository.findAll();
    }
}
