package com.scaler.myscalerproject.controllers;

import com.scaler.myscalerproject.dto.FakeStoreProductDto;
import com.scaler.myscalerproject.models.Product;
import com.scaler.myscalerproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping()
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id) {
        return productService.getSingleProduct(id);
    }
    @PostMapping()
    public Product addNewProduct(@RequestBody FakeStoreProductDto product) {
        return productService.addNewProduct(product);
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
