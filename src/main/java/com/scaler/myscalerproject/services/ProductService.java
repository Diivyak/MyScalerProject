package com.scaler.myscalerproject.services;

import com.scaler.myscalerproject.dto.FakeStoreProductDto;
import com.scaler.myscalerproject.exceptions.ProductNotExistsException;
import com.scaler.myscalerproject.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id) throws ProductNotExistsException;

    Product addNewProduct(Product product);

    Product updateProduct(Long id, Product product);
    List<Product> getAllProducts();

    Product replaceProduct(Long id, Product product);
    boolean deleteProduct(Long id);
}