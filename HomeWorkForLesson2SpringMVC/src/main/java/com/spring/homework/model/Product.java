package com.spring.homework.model;

import com.spring.homework.entity.ProductData;

import java.util.Objects;

public class Product {
    private Long id;
    private String title;
    private String description;
    private String brand;
    private double price;

    public Product(Long id, String title, String description, String brand, double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.brand = brand;
        this.price = price;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.getPrice(), getPrice()) == 0 &&
                Objects.equals(getId(), product.getId()) &&
                Objects.equals(getTitle(), product.getTitle()) &&
                Objects.equals(getDescription(), product.getDescription()) &&
                Objects.equals(getBrand(), product.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDescription(), getBrand(), getPrice());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
