package com.scaler.myscalerproject.inheritanceDemo.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_mentor")
public class Mentor extends User {
    @Id
    private Long Id;
    public double averageRating;
}
