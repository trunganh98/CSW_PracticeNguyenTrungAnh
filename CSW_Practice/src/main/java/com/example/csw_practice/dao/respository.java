package com.example.csw_practice.dao;

import com.example.csw_practice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface respository extends JpaRepository<Product, Long> {
}
