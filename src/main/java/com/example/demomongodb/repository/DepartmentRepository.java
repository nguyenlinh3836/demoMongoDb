package com.example.demomongodb.repository;

import com.example.demomongodb.model.entities.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, Integer> {

  Department findByName(String name);
  Department findById(int id);
}
