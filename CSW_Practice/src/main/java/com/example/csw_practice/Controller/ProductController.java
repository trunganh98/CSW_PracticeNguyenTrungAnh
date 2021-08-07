package com.example.csw_practice.Controller;

import com.example.csw_practice.entity.Product;
import com.example.csw_practice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> list() {
        List<Product> Customers = productService.listAll();
        return new ResponseEntity<>(Customers, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllTodos() {
        List<Product> todos = productService.listAll();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public Product Create(@RequestBody Product product) {
        Product product1 = productService.save(product);
        return product1;
    }

    @PutMapping("/buy")
    public ResponseEntity<Product> update(@RequestBody Product Customer) {
        Product Customer1 = productService.update(Customer.getId(),Customer);
        return new ResponseEntity<>(Customer1, HttpStatus.OK);
    }

    @DeleteMapping({"/{productId}"})
    public ResponseEntity<String> deleteCus(@PathVariable("productId") Long productId) {
        try {
            productService.deletebyId(productId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            catch (Exception e) {
                return new ResponseEntity<>("Not find by id: " + e,HttpStatus.NO_CONTENT);
            }

    }
}
