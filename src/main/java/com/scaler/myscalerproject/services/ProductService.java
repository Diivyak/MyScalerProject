package com.scaler.myscalerproject.services;

import com.scaler.myscalerproject.dto.FakeStoreProductDto;
import com.scaler.myscalerproject.models.Product;

public interface ProductService {

    Product getSingleProduct(Long id);

    Product addNewProduct(FakeStoreProductDto product);
}