package com.turkcell.spring.intro.services.concretes;

import java.util.List;
import org.springframework.stereotype.Service;
import com.turkcell.spring.intro.dtos.UserDTO;
import com.turkcell.spring.intro.entities.User;
import com.turkcell.spring.intro.repositories.UserRepository;
import com.turkcell.spring.intro.services.abstracts.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {
    private final UserRepository userRepository;
    
    @Override
    public void add(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        userRepository.save(user);
    }
    
    @Override
    public void update(User user) {
        userRepository.save(user);
    }
    
    @Override
    public void delete(int id) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null)
            throw new RuntimeException("There is no user with this id: " + id);
        userRepository.delete(user);
    }
    
    @Override
    public User getById(int id) {
        User user = userRepository.findById(id).orElse(null);
    
        if(user == null)
            throw new RuntimeException("There is no user with this id: " + id);
        
        return user;
    }
    
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
