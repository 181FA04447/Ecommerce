package com.example.productservice.Repository;

import com.example.productservice.Models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PriceRepo extends JpaRepository<Price, UUID> {
}
