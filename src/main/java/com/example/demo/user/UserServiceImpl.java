package com.example.demo.user;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    public UserRepo userRepo;

    UserServiceImpl(UserRepo userRepo){this.userRepo = userRepo;}

    @Override
    public Optional<User> getUserById(int id) {
        return userRepo.findById(id);

    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepo.deleteById(id);

    }

    @Override
    public User updateUser(int id, User userDetails) {
        User user = userRepo.findById(id).orElseThrow(); //use Elsethrow(). We can use optional but we cannot use setters or getters with optional.
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepo.save(user);
    }
}
