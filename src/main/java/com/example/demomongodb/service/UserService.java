package com.example.demomongodb.service;

import com.example.demomongodb.model.entities.User;
import java.util.List;
import org.springframework.stereotype.Service;


public interface UserService {
  List<User> getAllUser();
  User findByUser(String name);
  User createUser(User user);
  User updateUser(User user,int id);
  void deleteUser(int id);

}
