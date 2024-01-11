package services.liftNotes.Users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.liftNotes.Users.models.User;
import services.liftNotes.Users.service.UserService;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/secured")
    public String secured(){
        return "Hello Secured!";
    }

    @PostMapping("/add")
    public String add(@RequestBody User user){
        userService.saveUser(user);
        return "New user is added";
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
