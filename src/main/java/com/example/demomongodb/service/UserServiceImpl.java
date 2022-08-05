package com.example.demomongodb.service;

import com.example.demomongodb.model.entities.User;
import com.example.demomongodb.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> getAllUser() {
    return userRepository.findAll();
  }

  @Override
  public User findByUser(String name) {
    return userRepository.findByName(name);
  }

  @Override
  public User createUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public User updateUser(User user, int id) {
    user.setId(id);
    return userRepository.save(user);
  }

  @Override
  public void deleteUser(int id) {
    User user = userRepository.findUserById(id);
    userRepository.delete(user);
  }
}
