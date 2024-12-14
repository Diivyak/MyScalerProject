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
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }


    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }
}
