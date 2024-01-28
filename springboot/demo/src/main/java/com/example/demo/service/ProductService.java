package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProductDto;


public interface ProductService {
	public boolean savOrUpdate(ProductDto productdto);
	//public boolean deleteById(int id);
	//
	//public List<Product>getAllProduct();
	//public Optional<Product>getById(int id);
}