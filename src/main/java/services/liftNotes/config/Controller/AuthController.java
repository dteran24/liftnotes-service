package services.liftNotes.config.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.liftNotes.config.exceptions.UsernameAlreadyExists;
import services.liftNotes.config.models.LoginResponseDTO;
import services.liftNotes.config.models.RegistrationDTO;
import services.liftNotes.config.service.AuthService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        super();
        this.authService = authService;

    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody RegistrationDTO body) {
        try {
            authService.registerUser(body.getUsername(), body.getPassword());
            Map<String, String> response = new HashMap<>();

            response.put("message", "User Created!");
            response.put("username", body.getUsername());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (UsernameAlreadyExists e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Username already exists");
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody RegistrationDTO body) {
        try {
            LoginResponseDTO response =  authService.loginUser(body.getUsername(), body.getPassword());
            return new ResponseEntity<>( response, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Username or Password is incorrect!", HttpStatus.CONFLICT);
        }
    }
}