package com.turkcell.spring.intro.services.abstracts;

import java.util.List;
import com.turkcell.spring.intro.dtos.BorrowerDTO;
import com.turkcell.spring.intro.entities.*;

public interface BorrowerService {
    void add(BorrowerDTO borrower);
    void update(Borrower borrower);
    void delete(int id);
    Borrower getById(int id);
    List<Borrower> getAll();
}
