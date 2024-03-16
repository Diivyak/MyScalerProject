package com.scaler.myscalerproject.services;

import com.scaler.myscalerproject.dto.FakeStoreProductDto;
import com.scaler.myscalerproject.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id);

    Product addNewProduct(FakeStoreProductDto product);

    List<Product> getAllProducts();

    Product replaceProduct(Long id, Product product);
}