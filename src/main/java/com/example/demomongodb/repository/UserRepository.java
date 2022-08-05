package com.example.demomongodb.repository;

import com.example.demomongodb.model.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

  User findByName(String name);
  User findUserById(int id);
}
