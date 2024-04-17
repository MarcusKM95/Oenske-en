package com.example.wishcloud.model;

public class WishlistModel {

    private String product;
    private String productId;
    private String description;
    private int price;
    private String store;
    private int wishlistId;

    public WishlistModel(String product, String description, int price, String store, int wishlistId, String productId){
        this.product = product;
        this.description = description;
        this.price = price;
        this.store = store;
        this.wishlistId = wishlistId;
        this.productId = productId;
    }

    public String getProduct(){
        return product;
    }

    public String getDescription(){
        return description;
    }

    public int getPrice(){
        return price;
    }

    public String getStore(){
        return store;
    }

    public int getWishlistId(){
        return wishlistId;
    }
    public String getProductId(){
        return productId;
    }


}
