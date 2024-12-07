package com.scaler.myscalerproject.inheritancedemo.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_instructor")
public class Instructor extends User {
    @Id
    private Long Id;

    private String favouriteStudent;
}
