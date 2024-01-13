package services.liftNotes.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import services.liftNotes.Users.controller.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserNameOrEmail(String userName, String email);
    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);
}
