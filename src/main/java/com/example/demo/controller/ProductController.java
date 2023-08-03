package com.example.demo.controller;


import com.example.demo.exception.HnDBankException;
import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hndbank")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private Environment environment;
    @GetMapping(value = "/Products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() throws HnDBankException {
        List<ProductDTO> ProductList = productService.findAll();
        return new ResponseEntity<>(ProductList, HttpStatus.OK);
    }
    @GetMapping(value = "/Products/{ProductId}")
    public ProductDTO getProduct(@PathVariable Integer ProductId) throws HnDBankException {
        ProductDTO Product = productService.getProduct(ProductId);
        return Product;
    }
    @GetMapping(value = "/Product")
    public ResponseEntity<ProductDTO> getProductParam(@RequestParam Integer ProductId) throws HnDBankException {
        ProductDTO Product = productService.getProduct(ProductId);
        return new ResponseEntity<>(Product, HttpStatus.OK);
    }
    @PostMapping(value = "/Products")
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO Product) throws HnDBankException {
        Integer ProductId = productService.addProduct(Product);
        String successMessage = environment.getProperty("API.INSERT_SUCCESS") + ProductId;
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }
    @PutMapping(value = "/Products/{ProductId}")
    public ResponseEntity<String> updateProduct(@PathVariable Integer ProductId, @RequestBody ProductDTO Product)
            throws HnDBankException {
        productService.updateProduct(ProductId,Product);
        String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }
    @DeleteMapping(value = "/Products/{ProductId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer ProductId) throws HnDBankException {
        productService.deleteProduct(ProductId);
        String successMessage = environment.getProperty("API.DELETE_SUCCESS");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

}

