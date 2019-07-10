package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "PRODUCTS")
public class Product {
    private int id;
    private String name;
    List<Item> itemP = new ArrayList<>();

    public Product(){

    }

    public Product(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Column(name = "NAME", nullable = false)
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Item> getItemP() {
        return itemP;
    }

    public void setItemP(List<Item> items) {
        this.itemP = itemP;
    }
}
