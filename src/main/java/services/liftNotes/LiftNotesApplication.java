package services.liftNotes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import services.liftNotes.Excercises.models.Exercise;
import services.liftNotes.Excercises.repository.ExerciseRepository;
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
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, ExerciseRepository exerciseRepository) {
		return args -> {
			if (!roleRepository.findByAuthority("ADMIN").isPresent() || !userRepository.findByUsername("demo").isPresent()) {
				Role adminRole = roleRepository.save(new Role("ADMIN"));
				Role userRole = roleRepository.save(new Role("USER"));

				Set<Role> roles = new HashSet<>();
				roles.add(adminRole);
				Set<Role> demoRoles = new HashSet<>();
				demoRoles.add(userRole);

				ApplicationUser admin = new ApplicationUser("admin", passwordEncoder.encode("password"), roles);
				ApplicationUser demoUser = new ApplicationUser("demo", passwordEncoder.encode("password"), demoRoles);
				userRepository.save(demoUser);
				userRepository.save(admin);

				exerciseRepository.save(new Exercise(1, "Legs", "Leg Press", "The leg press is a compound exercise that targets the quadriceps, hamstrings, and glutes. It involves pushing a weighted sled with your feet in a seated position."));
				exerciseRepository.save(new Exercise(2, "Chest", "Dumbbell Chest Press", "The dumbbell chest press is a classic strength-training exercise for the chest muscles. It involves pressing dumbbells upward while lying on a bench."));
				exerciseRepository.save(new Exercise(3, "Arms", "Dumbbell Curls", "Dumbbell curls are a bicep isolation exercise. Hold a dumbbell in each hand, and with controlled movements, curl the weights towards your shoulders to work the biceps."));
				exerciseRepository.save(new Exercise(4, "Back", "Pull Ups", "Pull-ups are a great upper-body exercise that primarily targets the muscles of the back, including the latissimus dorsi. It also engages the biceps and core muscles."));
				exerciseRepository.save(new Exercise(5, "Legs", "Squats", "Compound exercise targeting quadriceps, hamstrings, and glutes."));
				exerciseRepository.save(new Exercise(6, "Chest", "Bench Press", "Primary compound movement for chest, shoulders, and triceps."));
				exerciseRepository.save(new Exercise(7, "Arms", "Tricep Dips", "Bodyweight exercise focusing on triceps and shoulders."));
				exerciseRepository.save(new Exercise(8, "Back", "Deadlifts", "Full-body compound movement working on back, glutes, and hamstrings."));
				exerciseRepository.save(new Exercise(9, "Shoulders", "Overhead Press", "Strengthens shoulder muscles and triceps."));
				exerciseRepository.save(new Exercise(10, "Legs", "Lunges", "Unilateral exercise targeting quads, hamstrings, and glutes."));
				exerciseRepository.save(new Exercise(11, "Chest", "Incline Dumbbell Press", "Targets upper chest muscles for a well-rounded chest workout."));
				exerciseRepository.save(new Exercise(12, "Arms", "Hammer Curls", "Bicep exercise emphasizing brachialis for arm development."));
				exerciseRepository.save(new Exercise(13, "Back", "Lat Pulldowns", "Isolation exercise for the upper back and lat muscles."));
				exerciseRepository.save(new Exercise(14, "Shoulders", "Lateral Raises", "Isolation movement to target lateral deltoids for broader shoulders."));
			};
		};
	}

}

