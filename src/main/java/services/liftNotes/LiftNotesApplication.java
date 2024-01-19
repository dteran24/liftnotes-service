package services.liftNotes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import services.liftNotes.config.models.ApplicationUser;
import services.liftNotes.config.models.Role;
import services.liftNotes.config.repository.RoleRepository;
import services.liftNotes.config.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class LiftNotesApplication {
	public static void main(String[] args) {
		SpringApplication.run(LiftNotesApplication.class, args);
	}
	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder){
		return  args -> {
			if(roleRepository.findByAuthority("ADMIN").isPresent())return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));
			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);
			ApplicationUser admin = new ApplicationUser("admin", passwordEncoder.encode("password"),roles);
			userRepository.save(admin);

		};
	}


}


