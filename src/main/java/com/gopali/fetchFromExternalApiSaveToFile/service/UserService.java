package com.gopali.fetchFromExternalApiSaveToFile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopali.fetchFromExternalApiSaveToFile.model.User;
import com.gopali.fetchFromExternalApiSaveToFile.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public boolean addUser(User user) {
        if (user == null)
            return false;
        else {
            userRepo.save(user); // ✅ Save to DB
            return true;
        }

    }

    public List<User> getUser() {
        return userRepo.findAll();

    }

    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    public User saveUser(Long id,User user) {
        User checkUser = userRepo.findById(id).orElse(null);
        if (checkUser == null) return null;

        user.setName(user.getName());
        return userRepo.save(user);
    }

    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }


}
