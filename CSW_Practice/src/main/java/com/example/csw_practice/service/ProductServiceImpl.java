package com.example.csw_practice.service;

import com.example.csw_practice.entity.Product;
import com.example.csw_practice.dao.respository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private respository respository;

    @Override
    public List<Product> listAll() {
        List<Product> todos = new ArrayList<>();
        respository.findAll().forEach(todos::add);

        return todos;
    }

    public Product Create(@RequestBody Product Customer) {
       return respository.save(Customer);
    }

    @Override
    public Product getById(Long id) {
        Product cus = respository.getById(id);
        return cus;
    }

    @Override
    public Product update(Long id, Product theEmployee) {
        Product customerFromDb = respository.findById(id).get();
        customerFromDb.setQuantity(customerFromDb.getQuantity() - theEmployee.getQuantity());
        return respository.save(customerFromDb);
    }

    @Override
    public Product save(Product theEmployee) {
        return respository.save(theEmployee);
    }

    @Override
    public void deletebyId(Long theId) {
        respository.deleteById(theId);
    }
}
