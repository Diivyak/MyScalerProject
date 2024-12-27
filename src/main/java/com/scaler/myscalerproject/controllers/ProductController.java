package com.scaler.myscalerproject.controllers;

import com.scaler.myscalerproject.commons.AuthenticationCommons;
import com.scaler.myscalerproject.dto.FakeStoreProductDto;
import com.scaler.myscalerproject.exceptions.ProductNotExistsException;
import com.scaler.myscalerproject.models.Product;
import com.scaler.myscalerproject.repositories.ProductRespository;
import com.scaler.myscalerproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private final ProductRespository productRespository;
    private RestTemplate restTemplate;
    private AuthenticationCommons authenticationCommons;


    @Autowired
    public ProductController(@Qualifier("SelfProductService") ProductService productService,
                             ProductRespository productRespository) {
        this.productService = productService;
        this.productRespository = productRespository;
        this.restTemplate = restTemplate;
        this.authenticationCommons = authenticationCommons;
    }
    @GetMapping()
    public  ResponseEntity<List<Product>> getAllProducts(@RequestHeader("AuthenticationToken") String token) {
////        restTemplate.delete(null);
//
//        UserDto userDto = authenticationCommons.validateToken(token);
//
//        if (userDto == null) {
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//
//        boolean isAdmin = false;
//
//        for (Role role: userDto.getRoles()) {
//            if (role.getName().equals("ADMIN")) {
//                isAdmin = true;
//                break;
//            }
//        }
//
//        if (!isAdmin) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        List<Product> products = productService.getAllProducts(); // o p q

        List<Product> finalProducts = new ArrayList<>();

        for (Product p: products) { // o  p q
            p.setTitle("Hello" + p.getTitle());
            finalProducts.add(p);
        }

        ResponseEntity<List<Product>> response = new ResponseEntity<>(
                finalProducts, HttpStatus.FORBIDDEN
        );
        return response;
    }
    @GetMapping("/{category}")
    public  ResponseEntity<List<Product>> getAllProductsByCategory(@PathVariable("category") String category) {
        ResponseEntity<List<Product>>  response = new ResponseEntity<>(
                productService.getProductsByCategory(category), HttpStatus.NOT_FOUND
        );
        return response;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id) throws ProductNotExistsException {

//        try {
            return new ResponseEntity<>(
                    productService.getSingleProduct(id), HttpStatus.OK);
//        }
//        catch (ArithmeticException exception) {
//            ResponseEntity<Product> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            return response;
//        }
//        throw new RuntimeException("Something went wrong");
//        return productService.getSingleProduct(id);
    }
    @PostMapping()
    public Product addNewProduct(@RequestBody Product product) {
        return productService.addNewProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,  @RequestBody Product product) {

        return productService.updateProduct(id, product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

}
