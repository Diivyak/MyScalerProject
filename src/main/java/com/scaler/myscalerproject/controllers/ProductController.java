package com.scaler.myscalerproject.controllers;

import com.scaler.myscalerproject.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping()
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }
    @GetMapping("/{id}")
    public Product getSinleProduct(@PathVariable("id") Long id) {
        return new Product();
    }
    @PostMapping()
    public Product addNewProduct(@RequestBody Product product) {
        Product p = new Product();
        p.setTitle("A new product");
        return new Product();
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,  @RequestBody Product product) {
        return new Product();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return new Product();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
    }

}
