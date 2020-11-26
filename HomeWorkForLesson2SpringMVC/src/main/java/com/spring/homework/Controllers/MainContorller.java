package com.spring.homework.Controllers;

import com.spring.homework.service.ProductService;
import com.spring.homework.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/app")
public class MainContorller {
private ProductService productService;
@Autowired
public MainContorller(ProductService productService){
    this.productService = productService;
}
    @GetMapping
    public String showApp(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "index";
    }
}
