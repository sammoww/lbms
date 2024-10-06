package com.example.demo.user;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User getUserById(int id);

    ResponseEntity<String> saveUser(User user);

    ResponseEntity<String> deleteUser(int id);

    User updateUser(int id, User user);

    List<User> getUsers();

    ResponseEntity<String> getResponse();
}
