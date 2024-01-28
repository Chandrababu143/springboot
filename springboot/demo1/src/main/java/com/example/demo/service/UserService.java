package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;

public interface UserService {
public boolean savOrUpdate(UserDto userDto);
public boolean deleteById(int id);
//public int softDeleteById(int id);
public List<User>getAllUser();
public Optional<User>getById(int id);
public String signUp(UserDto userdto);
public String signIn(String name,String Password);


}
