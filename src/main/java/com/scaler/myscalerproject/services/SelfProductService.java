package com.scaler.myscalerproject.services;

import com.scaler.myscalerproject.dto.FakeStoreProductDto;
import com.scaler.myscalerproject.exceptions.ProductNotExistsException;
import com.scaler.myscalerproject.models.Product;
import com.scaler.myscalerproject.repositories.CategoryRepository;
import com.scaler.myscalerproject.repositories.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public Product addNewProduct(FakeStoreProductDto product) {
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
}
