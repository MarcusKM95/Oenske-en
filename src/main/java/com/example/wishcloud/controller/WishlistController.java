package com.example.wishcloud.controller;

import com.example.wishcloud.model.WishlistModel;
import com.example.wishcloud.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;

    @Autowired
    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<WishlistModel>> getAllWishlists() {
        List<WishlistModel> wishlists = wishlistService.getAllWishlists();
        return ResponseEntity.ok(wishlists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WishlistModel> getWishlistById(@PathVariable int id) {
        WishlistModel wishlist = wishlistService.getWishlistById(id);
        if (wishlist != null) {
            return ResponseEntity.ok(wishlist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/dashboard/add")
    public ResponseEntity<Void> addWishlistFromDashboard(@RequestBody WishlistModel wishlistModel) {
        wishlistService.addWishlist(wishlistModel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
}

    @PutMapping("/update")
    public ResponseEntity<Void> updateWishlist(@RequestBody WishlistModel updatedWishlist) {
        wishlistService.updateWishlist(updatedWishlist);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWishlist(@PathVariable int id) {
        wishlistService.deleteWishlist(id);
        return ResponseEntity.ok().build();
    }
}
