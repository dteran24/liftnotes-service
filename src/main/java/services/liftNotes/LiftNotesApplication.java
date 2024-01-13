package services.liftNotes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import services.liftNotes.config.models.Role;
import services.liftNotes.config.repository.RoleRepository;

@SpringBootApplication
public class LiftNotesApplication {
	public static void main(String[] args) {
		SpringApplication.run(LiftNotesApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(RoleRepository roleRepo) {
		return (args) -> {
			Role role=new Role();
			role.setName("ROLE_ADMIN");
			roleRepo.save(role);
		};
	}

}


