package com.turkcell.spring.intro.repositories;

import com.turkcell.spring.intro.entities.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepository extends JpaRepository<Borrower,Integer> {

}
