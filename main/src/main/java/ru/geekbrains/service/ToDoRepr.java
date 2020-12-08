package ru.geekbrains.service;


import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ToDoRepr implements Serializable {

    
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Float price;
	
    @NotNull
    private Long quantity;

    
    private String description;
	
    public ToDoRepr() {
    }

    public ToDoRepr(Long id, String  name, Float price, Long quantity, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
