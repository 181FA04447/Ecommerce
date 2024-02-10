package com.example.productservice.Services;
import com.example.productservice.dto.GenricCategoryDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class CategoriesService {
    RestTemplateBuilder restTemplateBuilder;
    CategoriesService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    private String path="https://fakestoreapi.com/products/categories";
    private String pathforgetcategory="https://fakestoreapi.com/products/category/{type}";
    public List<String> getAllcategories()
    {
       RestTemplate restTemplate=restTemplateBuilder.build();
       ResponseEntity<String[]>response=restTemplate.getForEntity(path,String[].class);
       String arr[]=response.getBody();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        return list;
    }
    public List<GenricCategoryDto>getByCategory(String type)
    {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<GenricCategoryDto[]>response=restTemplate.getForEntity(pathforgetcategory,GenricCategoryDto[].class,type);
        GenricCategoryDto[] arr=response.getBody();
        ArrayList<GenricCategoryDto> list =new ArrayList<>(Arrays.asList(arr));
        return list;
    }
}
