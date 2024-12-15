package com.scaler.myscalerproject.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{

    private String title;
    private Double price;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Category category;
    private String description;
    private String imageUrl;
    private int numOfSales;
    private boolean isPop;
}
