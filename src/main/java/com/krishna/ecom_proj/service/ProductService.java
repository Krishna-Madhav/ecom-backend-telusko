package com.krishna.ecom_proj.service;

import com.krishna.ecom_proj.model.Product;
import com.krishna.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return productRepo.save(product);
    }

    public Product getProductById(int prodId) {
        return  productRepo.findById(prodId).orElse(null);
    }

    public Product updateProduct(int id, Product product, MultipartFile multipartFile) {
        return productRepo.save(product);
    }
}
