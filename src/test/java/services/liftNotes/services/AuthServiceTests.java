package services.liftNotes.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import services.liftNotes.config.exceptions.AccountDoesNotExist;
import services.liftNotes.config.exceptions.UsernameAlreadyExists;
import services.liftNotes.config.models.ApplicationUser;
import services.liftNotes.config.models.LoginResponseDTO;
import services.liftNotes.config.models.Role;
import services.liftNotes.config.repository.RoleRepository;
import services.liftNotes.config.repository.UserRepository;
import services.liftNotes.config.service.AuthService;
import services.liftNotes.config.service.TokenService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Optional;

@SpringBootTest
public class AuthServiceTests {
    @Autowired
    private AuthService authService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private TokenService tokenService;


    @Test
    void testRegisterUser() throws UsernameAlreadyExists {
        // Arrange
        String username = "testUser";
        String password = "testPassword";

        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());
        when(roleRepository.findByAuthority("USER")).thenReturn(Optional.of(new Role("USER")));

        // Act
        authService.registerUser(username, password);

        // Assert
        verify(userRepository, atMost(2)).save(any(ApplicationUser.class));
    }
    @Test
    void usernameAlreadyExistsException() {
        // Arrange
        String username = "testUser";
        String password = "testPassword";

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(new ApplicationUser()));

        // Act and Assert
        assertThrows(UsernameAlreadyExists.class, () -> authService.registerUser(username, password));

        // Verify that userRepository.save is not called
        verify(userRepository, atMostOnce()).save(any(ApplicationUser.class));
    }

    @Test
    void loginUser() throws AccountDoesNotExist {
        // Arrange
        String username = "testUser";
        String password = "testPassword";

        ApplicationUser user = new ApplicationUser(username, "encodedPassword", new HashSet<>());

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));
        when(authenticationManager.authenticate(any())).thenReturn(null);
        when(tokenService.generateJwt(any())).thenReturn("mockedJwtToken");

        // Act
        LoginResponseDTO responseDTO = authService.loginUser(username, password);

        // Assert
        verify(authenticationManager, times(1)).authenticate(any());
        verify(tokenService, times(1)).generateJwt(any());

    }
    @Test
    void testLoginUserAccountDoesNotExist() {
        // Arrange
        String nonExistingUsername = "nonExistingUser";
        String password = "testPassword";

        when(userRepository.findByUsername(nonExistingUsername)).thenReturn(Optional.empty());
        //Act
        assertThrows(AccountDoesNotExist.class, () -> authService.loginUser(nonExistingUsername, password));

        //Assert
        verify(authenticationManager, never()).authenticate(any());
        verify(tokenService, never()).generateJwt(any());


    }
}
