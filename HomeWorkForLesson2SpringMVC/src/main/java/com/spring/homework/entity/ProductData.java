package com.spring.homework.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "productsData")
public class ProductData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;
    @Column(name = "brand")
    private String brand;
    @Column(name = "price")
    private double price;

    public ProductData() {

    }

    public ProductData(String title, String description, String brand, double price) {
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
        if (!(o instanceof ProductData)) return false;
        ProductData productData = (ProductData) o;
        return Double.compare(productData.getPrice(), getPrice()) == 0 &&
                Objects.equals(getId(), productData.getId()) &&
                Objects.equals(getTitle(), productData.getTitle()) &&
                Objects.equals(getDescription(), productData.getDescription()) &&
                Objects.equals(getBrand(), productData.getBrand());
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
