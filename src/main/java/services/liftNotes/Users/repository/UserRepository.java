package services.liftNotes.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import services.liftNotes.Users.controller.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
