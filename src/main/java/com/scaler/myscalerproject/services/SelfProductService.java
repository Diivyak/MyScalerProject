package com.scaler.myscalerproject.services;

import com.scaler.myscalerproject.dto.FakeStoreProductDto;
import com.scaler.myscalerproject.exceptions.ProductNotExistsException;
import com.scaler.myscalerproject.models.Category;
import com.scaler.myscalerproject.models.Product;
import com.scaler.myscalerproject.repositories.CategoryRepository;
import com.scaler.myscalerproject.repositories.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements  ProductService{

    private ProductRespository productRespository;
    private CategoryRepository categoryRepository;


    @Autowired
    public SelfProductService(ProductRespository productRespository, CategoryRepository categoryRepository){
        this.productRespository = productRespository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException {
        Optional<Product> productOptional = productRespository.findById(id);

        if(productOptional.isEmpty()) {
            throw new ProductNotExistsException("Product with id  does not exists");
        }

        Product product = productOptional.get();
        return product;
    }

    @Override
    public Product addNewProduct(Product product) {
        Category category = product.getCategory();
//        if(category.getId() == null) {
//            Category savedCategory = categoryRepository.save(category);
//            product.setCategory(savedCategory);
//        }
        Optional<Category> categoryOptional = categoryRepository.findByName(product.getCategory().getName());
        if(categoryOptional.isEmpty()) {
            product.setCategory(categoryRepository.save(product.getCategory()));
        }
        return productRespository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> productOptional = productRespository.findById(id);
        if(productOptional.isEmpty()) throw new RuntimeException();
        Product savedProduct = productOptional.get();

        if(product.getTitle() != null) {
            savedProduct.setTitle(product.getTitle());
        }
        if(product.getDescription() != null) {
            savedProduct.setDescription(product.getDescription());
        }
        if(product.getPrice() != null) {
            savedProduct.setPrice(product.getPrice());
        }
        if(product.getImageUrl() != null) {
            savedProduct.setImageUrl(product.getImageUrl());
        }
        return productRespository.save(savedProduct);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRespository.findAll();
    }


    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRespository.deleteById(id);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        Optional<Category> categoryOptional = categoryRepository.findByName(category);
        if(!categoryOptional.isEmpty()) {
            Category savedCategory = categoryOptional.get();

           return  productRespository.findProductsByCategory(savedCategory);
        }
        return new ArrayList<Product>();
    }
}
