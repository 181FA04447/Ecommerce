package com.example.productservice.Services;
import com.example.productservice.Models.Product;
import com.example.productservice.dto.GenricDto;
import java.util.ArrayList;
public interface ProductService {
    public GenricDto getProductById(Long id);
    ArrayList<Product> getAllProducts();

    Product postproduct(GenricDto product);

}
