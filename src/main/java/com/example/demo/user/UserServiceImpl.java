package com.example.demo.user;

import com.example.demo.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    public UserRepo userRepo;

    UserServiceImpl(UserRepo userRepo){this.userRepo = userRepo;}

    @Override
    public User getUserById(int id) {
        return userRepo.findById(id).orElseThrow(()->new EntityNotFoundException("User with id "+ id + " not found." ));
    }

    @Override
    public ResponseEntity<String> saveUser(User user) {
        User userResponseBody = userRepo.save(user);

        if (userRepo.existsByEmail(userResponseBody.getEmail())){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Duplicate email. Please use another email");
        }
        String responseMessage = "The user with following details has been saved \n" +
                                    "UserId: " + userResponseBody.getId() + "\n" +
                                    "Username: " + userResponseBody.getName() + "\n" +
                                    "email: " + userResponseBody.getEmail();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseMessage);
    }

    @Override
    public ResponseEntity<String> deleteUser(int id) {
        if(userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("User with id "+id+" has been deleted.");
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id "+ id +" does not exist");
    }

    @Override
    public User updateUser(int id, User userDetails) {
        User user = userRepo.findById(id).orElseThrow(); //use Elsethrow(). We can use optional but we cannot use setters or getters with optional.
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepo.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public ResponseEntity<String> getResponse() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("wow", "A-OK")
                .body("Test successful");
    }

}
