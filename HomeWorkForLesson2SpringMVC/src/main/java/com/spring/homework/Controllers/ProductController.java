package com.spring.homework.Controllers;

import com.spring.homework.service.ProductService;
import com.spring.homework.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
private ProductService productService;



@Autowired
public ProductController(ProductService productService){
    this.productService = productService;
}


    @GetMapping
    public String showAll(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);

        return "products";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
    return "product_add_form";
    }

    @PostMapping("/add")
    public String addProduct( @ModelAttribute Product newProduct){
   productService.saveOrUpdate(newProduct);
   return "redirect:/products/";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
    model.addAttribute("product", productService.findById(id));
    return "product_edit_form";
    }

    @PostMapping("/edit")
    public String modifyProduct( @ModelAttribute Product modifiedProduct){
    productService.saveOrUpdate(modifiedProduct);
    return "redirect:/products/";
    }

    @GetMapping(value = "json/{id}")
    public HttpEntity showJsonProduct(@PathVariable Long id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Product> entity = new HttpEntity<>(productService.findById(id), headers);
        return entity;
    }

    @GetMapping(value = "/product/{id}")
    public String showProduct(@PathVariable Long id, Model model){
    Product product = productService.findById(id);
    model.addAttribute("product", product);
    return "product_info";
    }

}
