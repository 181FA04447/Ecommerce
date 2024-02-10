package com.example.productservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Category extends Base{
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> product;
}
