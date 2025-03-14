package com.meeshoclone.meeshoclone.service;

import com.meeshoclone.meeshoclone.model.Product;
import com.meeshoclone.meeshoclone.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // ✅ Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // ✅ Get product by ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // ✅ Create new product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // ✅ Update product
    public Product updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id).map(product -> {
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // ✅ Delete product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
