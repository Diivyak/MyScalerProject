package com.scaler.myscalerproject.inheritancedemo.joinedtable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Instructor extends User {
    private String favouriteStudent;
}
