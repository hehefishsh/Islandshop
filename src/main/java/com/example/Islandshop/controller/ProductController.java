package com.example.Islandshop.controller;

import com.example.Islandshop.entity.Product;
import com.example.Islandshop.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
@Tag(name = "Products",description = "管理商品 API")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/form")
    public String createForm() {
        return "product-form";
    }


    @GetMapping("/list")
    public String listPage(Model model) {
        model.addAttribute("products", productService.findAllProduct());
        return "product-list";
    }


    @ResponseBody
    @GetMapping
    @Operation(summary = "取得所有商品",description = "取得所有3C商品")
    public List<Product> getAll() {
        return productService.findAllProduct();
    }

    @ResponseBody
    @GetMapping("/{id}")
    @Operation(summary = "用Id取得商品", description = "用Id取得3C商品")
    public Product getProductById(@PathVariable("id") Integer id) {
        return productService.findProductById(id);
    }

    @ResponseBody
    @PostMapping
    @Operation(summary = "新增商品",description = "新增3C商品")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }


    @ResponseBody
    @PutMapping("/{id}")
    @Operation(summary = "編輯商品",description = "用Id編輯3C商品")
    public Product update(@PathVariable Integer id, @RequestBody Product product) {
        System.out.println("編輯商品");
        product.setId(id);
        return productService.updateProduct(product);
    }


    @ResponseBody
    @DeleteMapping("/{id}")
    @Operation(summary = "刪除商品",description = "用Id刪除3C商品")
    public void delete(@PathVariable Integer id) {
        productService.deleteById(id);
    }
}
