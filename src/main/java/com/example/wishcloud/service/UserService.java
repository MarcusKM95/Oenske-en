package com.example.wishcloud.service;

import com.example.wishcloud.model.UserModel;
import com.example.wishcloud.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService {

    private final WishlistRepository wishlistRepository;

    @Autowired
    public UserService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    // CRUD operation for User
    public void createUser(UserModel user) {
        wishlistRepository.createUser(user);
    }

    public UserModel getUserById(int userId) {
        return wishlistRepository.readUserById(userId);
    }

    public void updateUser(UserModel updatedUser) {
        wishlistRepository.updateUser(updatedUser);
    }

    public void deleteUser(int userId) {
        wishlistRepository.deleteUser(userId);
    }

    public List<UserModel> getAllUsers() {
        return wishlistRepository.getAllUsers();
    }
    public String generateRandomUserId() {
        Random random = new Random();
        int randomId = random.nextInt(1000);
        return "USR-" + randomId;
    }
    public UserModel validateLogin(String username, String password) {
        return wishlistRepository.validateLogin(username, password);
    }

}
