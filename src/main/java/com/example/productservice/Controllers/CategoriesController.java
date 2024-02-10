package com.example.productservice.Controllers;
import com.example.productservice.Services.CategoriesService;
import com.example.productservice.dto.GenricCategoryDto;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class CategoriesController {
    private CategoriesService Categoriesservice;
    CategoriesController(CategoriesService Categoriesservice)
    {
        this.Categoriesservice=Categoriesservice;
    }
    @GetMapping("/categories")
    public List<String> getAllcategories()
    {
        return Categoriesservice.getAllcategories();
    }
    @GetMapping("/category/{type}")
    public List<GenricCategoryDto>getByCategory(@PathVariable("type") String type)
    {
        System.out.print(type);
        return Categoriesservice.getByCategory(type);
    }
}
