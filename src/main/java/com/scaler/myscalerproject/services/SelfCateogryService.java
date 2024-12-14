package com.scaler.myscalerproject.services;

import com.scaler.myscalerproject.models.Category;
import com.scaler.myscalerproject.repositories.CategoryRepository;
import com.scaler.myscalerproject.repositories.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfCateogryService")
public class SelfCateogryService implements  CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public SelfCateogryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
