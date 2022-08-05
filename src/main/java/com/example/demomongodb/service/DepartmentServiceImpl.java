package com.example.demomongodb.service;

import com.example.demomongodb.model.entities.Department;
import com.example.demomongodb.repository.DepartmentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{
  private final DepartmentRepository departmentRepository;

  public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  @Override
  public List<Department> getAllDepart() {
    return departmentRepository.findAll();
  }

  @Override
  public Department findByDepartName(String name) {
    return departmentRepository.findByName(name);
  }

  @Override
  public Department createDepart(Department department) {
    return departmentRepository.save(department);
  }

  @Override
  public Department updateDepart(Department department, int id) {
    department.setId(id);
    return departmentRepository.save(department);
  }

  @Override
  public void deleteDepart(int id) {
    Department department = departmentRepository.findById(id);
    departmentRepository.delete(department);
  }
}
