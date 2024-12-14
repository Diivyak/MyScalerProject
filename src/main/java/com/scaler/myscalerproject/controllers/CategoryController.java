package com.scaler.myscalerproject.controllers;

import com.scaler.myscalerproject.models.Category;
import com.scaler.myscalerproject.models.Product;
import com.scaler.myscalerproject.repositories.CategoryRepository;
import com.scaler.myscalerproject.repositories.ProductRespository;
import com.scaler.myscalerproject.services.CategoryService;
import com.scaler.myscalerproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(@Qualifier("SelfCateogryService") CategoryService categoryService,
                             CategoryRepository categoryRepository) {
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }
    @GetMapping()
    public ResponseEntity<List<Category>> getAllCategories() {
        ResponseEntity<List<Category>>  response = new ResponseEntity<>(
                categoryService.getAllCategories(), HttpStatus.NOT_FOUND
        );
        return response;
    }
}
