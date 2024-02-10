package com.example.productservice.Repository;
import com.example.productservice.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.UUID;
@Repository
public interface Productrepo extends JpaRepository<Product, UUID> {
    @Query(value = "select * from Product where title= :title ",nativeQuery = true)
    Product findBytitle(String title);
}
