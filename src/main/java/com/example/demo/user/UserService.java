package com.example.demo.user;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(int id);

    User saveUser(User user);

    void deleteUser(int id);

    User updateUser(int id,User user);

}
