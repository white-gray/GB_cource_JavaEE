package ru.geekbrains.persist;

import java.time.LocalDate;

public class ToDo {

    private Long id;
    private String item;
    private int price;
    private int quantity;
    private String description;


    public ToDo() {
    }

    public ToDo(Long id, String item, int price, int quantity, String description) {
        this.id = id;
        this.item = item;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String  getItem() {
        return item;
    }
    public void setItem(String id) {
        this.item = id;
    }

    public int  getPrice() {
        return price;
    }
    public void setPrice(int id) {
        this.price = price;
    }

    public int  getQuantity() {
        return quantity;
    }
    public void setQuantity(int id) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
