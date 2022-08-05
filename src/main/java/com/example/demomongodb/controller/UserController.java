package com.example.demomongodb.controller;

import com.example.demomongodb.model.entities.Department;
import com.example.demomongodb.model.entities.User;
import com.example.demomongodb.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }
  @GetMapping
  public ResponseEntity<List<User>> listUser() {
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.getAllUser());
  }

  @GetMapping("/{name}")
  public ResponseEntity<?> getUserByName(@PathVariable("name") String name) {
    return ResponseEntity.status(HttpStatus.ACCEPTED)
        .body(userService.findByUser(name));
  }

  @PostMapping
  public ResponseEntity<?> createUser(@RequestBody User user) {
    return ResponseEntity.status(HttpStatus.ACCEPTED)
        .body(userService.createUser(user));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateUser(@RequestBody User user,
      @PathVariable("id") int id) {
    return ResponseEntity.status(HttpStatus.ACCEPTED)
        .body(userService.updateUser(user,id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
   userService.deleteUser(id);
    return ResponseEntity.ok(HttpStatus.NO_CONTENT);
  }
}
