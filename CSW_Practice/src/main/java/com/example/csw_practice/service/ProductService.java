package com.example.csw_practice.service;

import com.example.csw_practice.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> listAll();

    public Product Create(Product theEmployee);

    public Product getById(Long id);

    public Product update(Long id, Product theEmployee);

    public Product save(Product theEmployee);

    public void deletebyId(Long theId);
}
