package com.turkcell.spring.intro.services.abstracts;

import java.util.List;
import com.turkcell.spring.intro.dtos.UserDTO;
import com.turkcell.spring.intro.entities.User;

public interface UserService {
    void add(UserDTO user);
    void update(User user);
    void delete(int id);
    User getById(int id);
    List<User> getAll();
}
