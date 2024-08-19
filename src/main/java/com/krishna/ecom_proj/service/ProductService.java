package com.krishna.ecom_proj.service;

import com.krishna.ecom_proj.model.Product;
import com.krishna.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public void addProduct(Product product) {
        productRepo.save(product);
    }

    public Product getProductById(int prodId) {

        return  productRepo.findById(prodId).orElse(null);
    }

}
