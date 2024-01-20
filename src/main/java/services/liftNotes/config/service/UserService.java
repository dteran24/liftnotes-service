package services.liftNotes.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import services.liftNotes.config.models.ApplicationUser;
import services.liftNotes.config.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
    public UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        super();
        this.userRepository = userRepository;
    }


    @Override
    public ApplicationUser loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));

    }
}