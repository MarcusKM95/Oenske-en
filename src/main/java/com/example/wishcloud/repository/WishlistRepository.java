package com.example.wishcloud.repository;

import com.example.wishcloud.model.UserModel;
import com.example.wishcloud.model.WishlistModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class WishlistRepository {

    private List<UserModel> users;
    private List<WishlistModel> wishlists;

    public WishlistRepository() {
        this.users = new ArrayList<>();
        this.wishlists = new ArrayList<>();
    }

    // CRUD operations for User
    public void createUser(UserModel user) {
        users.add(user);
    }

    public UserModel readUserById(int userId) {
        for (UserModel user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    public void updateUser(UserModel updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            UserModel user = users.get(i);
            if (user.getUserId() == updatedUser.getUserId()) {
                users.set(i, updatedUser);
                break;
            }
        }
    }

    public void deleteUser(int userId) {
        users.removeIf(user -> user.getUserId() == userId);
    }

    // CRUD operations for Wishlist
    public void createWishlist(WishlistModel wishlist) {
        wishlists.add(wishlist);
    }

    public WishlistModel readWishlistById(int wishlistId) {
        for (WishlistModel wishlist : wishlists) {
            if (wishlist.getWishlistId() == wishlistId) {
                return wishlist;
            }
        }
        return null;
    }

    public void updateWishlist(WishlistModel updatedWishlist) {
        for (int i = 0; i < wishlists.size(); i++) {
            WishlistModel wishlist = wishlists.get(i);
            if (wishlist.getWishlistId() == updatedWishlist.getWishlistId()) {
                wishlists.set(i, updatedWishlist);
                break;
            }
        }
    }

    public void deleteWishlist(int wishlistId) {
        wishlists.removeIf(wishlist -> wishlist.getWishlistId() == wishlistId);
    }

    public List<WishlistModel> getAllWishlists() {
        return wishlists;
    }

    public List<UserModel> getAllUsers() {
        return users;
    }

    public UserModel validateLogin(String username, String password) {
        for (UserModel user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }


}