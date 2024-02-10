package com.example.productservice;

import com.example.productservice.Models.Category;
import com.example.productservice.Models.Orders;
import com.example.productservice.Models.Price;
import com.example.productservice.Models.Product;
import com.example.productservice.Repository.Categoryrepo;
import com.example.productservice.Repository.OrdersRepo;
import com.example.productservice.Repository.PriceRepo;
import com.example.productservice.Repository.Productrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

     @Autowired
     Categoryrepo catergoryrepo;
     @Autowired
     Productrepo productrepo;
     @Autowired
     OrdersRepo ordersRepo;
     @Autowired
     PriceRepo priceRepo;
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Product p1=new Product();
        Category c=new Category();
        c.setName("Mobiles phones");
        Category c2=new Category();
        c2.setName("Tshirts");
        Category saved=catergoryrepo.save(c);
        Category saved2=catergoryrepo.save(c2);
        p1.setCategory(saved);
        p1.setDescrption("This is the phone1");
        p1.setImage("this is th eimage url");
        p1.setTitle("redmi");
        Price price1=new Price();
        price1.setPrice(100000);
        price1.setCurrency("indian");
        priceRepo.save(price1);
        p1.setPrice(price1);
        productrepo.save(p1);
        Product p2=new Product();
        Price price2=new Price();
        price2.setCurrency("Inr");
        price2.setPrice(100000);
        priceRepo.save(price2);
        p2.setPrice(price2);
        p2.setImage("This is the image link of the tshirt");
        p2.setCategory(saved2);
        p2.setDescrption("Brand new fit shirt");
        p2.setTitle("Allen solly thirt");
        productrepo.save(p2);
//        System.out.println(p3.getUuid());
//        System.out.println(p3.getTitle());
//        System.out.println(p3.getDescrption());
//        System.out.println(p3.getCategory());
        List<Category> c3=catergoryrepo.findAll();
        for (Category category : c3) {
            System.out.println(category.getName());
        }
        Orders order1=new Orders();
        List<Product>products=new ArrayList<>();
        products.add(p1);
        products.add(p2);
        order1.setProducts(products);
        ordersRepo.save(order1);
        Optional<Product>productOptional= Optional.ofNullable(productrepo.findBytitle("redmi"));
        if(productOptional.isPresent()) {
            Product P3=productOptional.get();
            System.out.println(P3.getCategory() + " " + P3.getPrice() + " " + P3.getDescrption());
        }
    }
}
