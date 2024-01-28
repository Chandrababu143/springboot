package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
@RestController
@CrossOrigin("*")
@RequestMapping(value="/pro")
public class UserController {
	@Autowired
	UserService userService;
	@PostMapping("/saveorup")
	public boolean savOrUpdate( @RequestBody  UserDto user) {
	return userService.savOrUpdate(user);
	
	
	}
	
	@GetMapping("/gau")
	public List<User>getAllUser(){
		return userService.getAllUser();
		
	}
	@GetMapping("/lo")
	public Optional<User>getById(int id){
		return userService.getById(id);
	}
	@DeleteMapping("/ol")
	public boolean deleteById(int id) {
		return userService.deleteById(id);
	}
//	@DeleteMapping("/ko")
//	public int softDeleteById(int id) {
//		return userService.softDeleteById(id);
//	}
	@PostMapping("/signup")
	public String signUp(@RequestBody UserDto userdto) {
		return userService.signUp(userdto);
	}
	@PostMapping("/signin")
	public String signIn(String phone,String password) {
		return userService.signIn(phone, password);
	}
	
	
}