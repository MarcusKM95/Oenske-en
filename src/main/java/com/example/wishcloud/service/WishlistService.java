package com.example.wishcloud.service;

import com.example.wishcloud.model.WishlistModel;
import com.example.wishcloud.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;

    @Autowired
    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    // CREATE operation
    public void addWishlist(WishlistModel wishlistModel) {
        wishlistRepository.createWishlist(wishlistModel);
    }

    // READ operation
    public List<WishlistModel> getAllWishlists() {
        return wishlistRepository.getAllWishlists();
    }

    public WishlistModel getWishlistById(int id) {
        return wishlistRepository.readWishlistById(id);
    }

    // UPDATE operation
    public void updateWishlist(WishlistModel updatedWishlist) {
        wishlistRepository.updateWishlist(updatedWishlist);
    }

    // DELETE operation
    public void deleteWishlist(int id) {
        wishlistRepository.deleteWishlist(id);
    }
}