package services.liftNotes.config.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.liftNotes.config.models.ApplicationUser;
import services.liftNotes.config.models.LoginResponseDTO;
import services.liftNotes.config.models.RegistrationDTO;
import services.liftNotes.config.service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body){
        return  authService.registerUser(body.getUsername(), body.getPassword());
    }
    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return authService.loginUser(body.getUsername(),body.getPassword());
    }
}