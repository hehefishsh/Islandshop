package com.example.Islandshop.service;

import com.example.Islandshop.entity.Product;
import com.example.Islandshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    public Product findProductById(Integer id){
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteById(Integer id){
        productRepository.deleteById(id);
    }

    public Product updateProduct(Product product) {
        if (product.getId() != null && productRepository.existsById(product.getId())) {
            return productRepository.save(product);
        } else {
            throw new IllegalArgumentException("更新失敗，該商品不存在");
        }
    }


}
