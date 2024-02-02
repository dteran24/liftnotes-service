package services.liftNotes.config.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import services.liftNotes.config.exceptions.AccountDoesNotExist;
import services.liftNotes.config.exceptions.UsernameAlreadyExists;
import services.liftNotes.config.models.LoginResponseDTO;
import services.liftNotes.config.repository.UserRepository;
import services.liftNotes.config.models.ApplicationUser;
import services.liftNotes.config.models.Role;
import services.liftNotes.config.repository.RoleRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Autowired
    public AuthService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager,
                       TokenService tokenService){
        super();
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager =authenticationManager;
        this.tokenService = tokenService;
    }


    public void registerUser(String username, String password) throws UsernameAlreadyExists {
        if(userRepository.findByUsername(username).isPresent()){
            throw new UsernameAlreadyExists("Username '" + username + "' already exists.");
        }else{
            String encodedPassword = passwordEncoder.encode(password);
            Role userRole = roleRepository.findByAuthority("USER").get();
            Set<Role> authorities = new HashSet<>();
            authorities.add(userRole);

            userRepository.save(new ApplicationUser(username, encodedPassword, authorities));
        }
    }

    public LoginResponseDTO loginUser(String username, String password) throws AccountDoesNotExist {
        Optional<ApplicationUser> user = userRepository.findByUsername(username);
        if (user.isPresent()){
            try {
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(username, password)
                );

                String token = tokenService.generateJwt(authentication);

                return new LoginResponseDTO(user.get(), token);

            } catch (AuthenticationException e) {
                throw new AccountDoesNotExist();
            }
        }else{
            throw new AccountDoesNotExist();
        }
    }
}