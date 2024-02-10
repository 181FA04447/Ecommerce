package com.example.productservice.Controllers;
import com.example.productservice.Models.Product;
import com.example.productservice.Services.FakeStoreProductService;
import com.example.productservice.Services.ProductService;
import com.example.productservice.dto.GenricDto;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
@RestController
@RequestMapping("/products")
public class ProductController {
     private ProductService productService;
    ProductController(FakeStoreProductService productService)
    {
        this.productService=productService;
    }
    @GetMapping("{id}")
    public GenricDto getProductById(@PathVariable("id") Long id)
    {
         return productService.getProductById(id);
    }
    @DeleteMapping("{id}")
    public String DeleteById(@PathVariable("id") Long id)
    {
        if(id==1234)
            return "sorry we havent find an item with id"+id+"select a different id";
        else
            return  "The item has been removed from the cart with id="+id;
    }
    @GetMapping()
    public ArrayList<Product> getAllProducts()
    {
       return  productService.getAllProducts();
    }
    @PostMapping
    public Product postproduct(@RequestBody GenricDto product)
    {
        return productService.postproduct(product);
    }
}
