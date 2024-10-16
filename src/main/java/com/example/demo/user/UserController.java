package com.example.demo.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userServ;

    UserController(UserService userService){userServ = userService;}

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable int id){
        return userServ.getUserById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody User user){
        return userServ.saveUser(user);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Integer id,@RequestBody User userDetails){
        return userServ.updateUser(id,userDetails);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        return userServ.deleteUser(id);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userServ.getUsers();
    }

}
