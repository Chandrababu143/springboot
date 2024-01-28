package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Product;
import com.example.demo.dto.ProductDto;
import com.example.demo.service.ProductService;



@RestController
@CrossOrigin("*")
public class ProductController {
	@Autowired
	ProductService productservice;
	@PostMapping("/saveorup")
	public boolean savOrUpdate( @RequestParam  ProductDto productdto)
	{
		return  productservice.savOrUpdate(productdto);
	}
	public boolean deleteById(int id)
	{
		return false;
	}

	public List<Product>getAllProduct()
	{
		return null;
		
	}
	public Optional<Product>getById(int id)
	{
		return null;
		
	}
	

	
}
