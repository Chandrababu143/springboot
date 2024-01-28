package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;
import com.example.demo.dto.ProductDto;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
    ProductRepository productrepository;
	@Override
	public boolean savOrUpdate(ProductDto productdto) {
	    Product pro=new Product();
	    pro.setId(productdto.getId());
	    pro.setProductname(productdto.getProductname());
	    pro.setProductprice(productdto.getProductprice());
	    productrepository.save(pro);
		return true;
	}
//	@Override
//	public boolean deleteById(int id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public List<Product> getAllProduct() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Optional <Product> getById(int id) {
//		// TODO Auto-generated method stub
//		return Optional.empty();
//	}

}
