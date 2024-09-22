package com.example.demo.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userServ;

    UserController(UserService userService){userServ = userService;}

    @GetMapping("/getUserById/{id}")
    public Optional<User> getUserById(@PathVariable int id){
        return userServ.getUserById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return  new ResponseEntity<>(userServ.saveUser(user), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Integer id,@RequestBody User userDetails){
        return userServ.updateUser(id,userDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        userServ.deleteUser(id);
    }
}
