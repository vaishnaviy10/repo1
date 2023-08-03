package com.example.demo.service;

import com.example.demo.exception.HnDBankException;
import com.example.demo.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    public int addProduct(ProductDTO Product) throws HnDBankException;
    public ProductDTO getProduct(Integer ProductId) throws HnDBankException;
    public List<ProductDTO> findAll() throws HnDBankException;
    public void updateProduct(Integer ProductId, ProductDTO productDTO) throws HnDBankException;
    public void deleteProduct(Integer ProductId)throws HnDBankException;


//    void findBy(String emailId, int custId) throws HnDBankException;
}

