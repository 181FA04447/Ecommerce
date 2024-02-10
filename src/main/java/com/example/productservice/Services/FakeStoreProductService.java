package com.example.productservice.Services;
import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import com.example.productservice.Repository.Categoryrepo;
import com.example.productservice.Repository.Productrepo;
import com.example.productservice.dto.GenricDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class FakeStoreProductService implements ProductService{
    @Autowired
    private RestTemplateBuilder restTemplatebuilder;
    private String path="https://fakestoreapi.com/products/1";
    private String pathforAllproducts="https://fakestoreapi.com/products";
    @Autowired
    private Productrepo productrepo;
    @Autowired
    private Categoryrepo categoryrepo;
    public FakeStoreProductService(RestTemplateBuilder restTemplatebuilder)
    {
        this.restTemplatebuilder=restTemplatebuilder;
    }
    public ArrayList<Product> getAllProducts(){
//        RestTemplate restTemplate=restTemplatebuilder.build();
//        ResponseEntity<GenricDto[]>response=restTemplate.getForEntity(pathforAllproducts,GenricDto[].class);
//        GenricDto arr[]=response.getBody();
//        ArrayList<GenricDto>list=new ArrayList<>();
//        for(int i=0;i<arr.length;i++)
//            list.add(arr[i]);
//        return list;
          ArrayList<Product> list= (ArrayList<Product>) productrepo.findAll();
          return  list;
    }
    @Override
    public GenricDto getProductById(Long id) {
        RestTemplate resttemplate=restTemplatebuilder.build();
        ResponseEntity<GenricDto> response=resttemplate.getForEntity(path,GenricDto.class,id);
        GenricDto genricdto=response.getBody();
        return genricdto;
    }
    @Override
    public Product postproduct(GenricDto product) {
//        RestTemplate restTemplate=restTemplatebuilder.build();
//        ResponseEntity<GenricDto>response=restTemplate.postForEntity(pathforAllproducts,product, GenricDto.class);
//        return response.getBody();
        Product p=new Product();
        p.setTitle(product.getTitle());
        //p.setDescrption(product.getdescription());
        //p.setPrice(product.getPrice());
        p.setImage(product.getImage());
        Category c=new Category();
        c.setName(String.valueOf(product.getCategory()));
        categoryrepo.save(c);
        p.setCategory(c);
        productrepo.save(p);
        return p;
    }
}
