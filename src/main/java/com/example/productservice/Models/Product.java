package com.example.productservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends Base{
     private String title;
     @ManyToOne
     private Category category;
     private String descrption;
     private String image;
     @OneToOne
     private Price price;
}
