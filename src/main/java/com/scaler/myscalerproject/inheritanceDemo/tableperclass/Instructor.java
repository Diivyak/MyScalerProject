package com.scaler.myscalerproject.inheritanceDemo.tableperclass;

import com.scaler.myscalerproject.tableperclass.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_instructor")
public class Instructor extends User {
    private String favouriteStudent;
}
