package com.example.productservice.Repository;

import com.example.productservice.Models.Orders;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public  interface OrdersRepo extends JpaRepository<Orders, UUID> {
    @Override
    <S extends Orders> S save(S entity);
}
