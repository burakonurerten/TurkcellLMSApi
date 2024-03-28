package com.turkcell.spring.intro.services.abstracts;

import java.util.List;
import com.turkcell.spring.intro.dtos.BookDTO;
import com.turkcell.spring.intro.entities.*;

public interface BookService {
    void add(BookDTO book);
    void update(Book book);
    void delete(int id);
    Book getById(int id);
    List<Book> getAll();
}
