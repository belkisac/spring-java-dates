package com.example.dateproject.models;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private int id;

    @NotNull
    @Size(min = 1, message = "Field cannot be empty")
    private String name;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Product> products = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Category(String name) {
        this.name = name;
    }

    public Category() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product newProduct) {
        products.add(newProduct);
    }

    public void removeProduct(Product deletedProduct) {
        products.remove(deletedProduct);
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}