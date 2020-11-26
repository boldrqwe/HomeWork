package com.spring.homework.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table
@NamedQuery(name = "Customer.findAll", query = "FROM Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "product")
    private String product;

    @Transient
    private String value;

    public Customer(){

    }

    public Customer(String name, String product){
        this.name = name;
        this.product = product;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getId().equals(customer.getId()) &&
                getName().equals(customer.getName()) &&
                getProduct().equals(customer.getProduct()) &&
                getValue().equals(customer.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getProduct(), getValue());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", product='" + product + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
