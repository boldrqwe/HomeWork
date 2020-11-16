package ProductShop;

import org.springframework.stereotype.Component;

import java.awt.*;

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


}
