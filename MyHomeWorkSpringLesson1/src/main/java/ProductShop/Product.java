package ProductShop;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Objects;

public class Product {
    int id;
    String name;
    int price;


    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId(){
        return id;
    }
    @Override
    public String toString(){
        return new String("id = "+ id+" name = " + name+ " price = "+price+"\n");
    }
    public int getPrice(){
        return price;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId() == product.getId() &&
                getPrice() == product.getPrice() &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name, getPrice());
    }
}
