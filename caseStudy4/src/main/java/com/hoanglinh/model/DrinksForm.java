package com.hoanglinh.model;


import org.springframework.web.multipart.MultipartFile;

public class DrinksForm {
    private String id;
    private String name;
    private Long price;       //gia
    private String description;
    private Long likes;
    private Long purchase;    //luot mua
    private Long quantity;
    private MultipartFile image;

    public String getId() {
        return id;
    }

    public DrinksForm(String id, String name, Long price, String description, Long likes, Long purchase, Long quantity, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.likes = likes;
        this.purchase = purchase;
        this.quantity = quantity;
        this.image = image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getPurchase() {
        return purchase;
    }

    public void setPurchase(Long purchase) {
        this.purchase = purchase;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
