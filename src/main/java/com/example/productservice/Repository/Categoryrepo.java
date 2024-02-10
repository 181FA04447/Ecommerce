package com.example.productservice.Repository;
import com.example.productservice.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
@Repository
public interface Categoryrepo extends JpaRepository<Category, UUID> {


}
