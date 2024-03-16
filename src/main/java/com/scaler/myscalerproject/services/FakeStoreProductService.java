package com.scaler.myscalerproject.services;

import com.scaler.myscalerproject.dto.FakeStoreProductDto;
import com.scaler.myscalerproject.models.Category;
import com.scaler.myscalerproject.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());
        product.setImageUrl(fakeStoreProductDto.getImage());

        return product;
    }

    private FakeStoreProductDto converProductTotFakeStoreProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        fakeStoreProductDto.setImage(product.getImageUrl());
        return fakeStoreProductDto;
    }
    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductDto productDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

        return convertFakeStoreProductToProduct(productDto);
    }

    @Override
    public Product addNewProduct(FakeStoreProductDto product) {
        FakeStoreProductDto productDto = restTemplate.postForObject("https://fakestoreapi.com/products",product, FakeStoreProductDto.class);
        return convertFakeStoreProductToProduct(productDto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] response = restTemplate.getForObject("https://fakestoreapi.com/products/", FakeStoreProductDto[].class);
        List<Product> answer = new ArrayList<>();

        for(FakeStoreProductDto dto: response) {
            answer.add(convertFakeStoreProductToProduct(dto));
        }
        return answer;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }


}
