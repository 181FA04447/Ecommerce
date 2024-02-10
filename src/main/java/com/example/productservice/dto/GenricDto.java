package com.example.productservice.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GenricDto{
    private long  id;
    private String title;
    private int price;
    private String category;
    private String description;
    private String image;
}
