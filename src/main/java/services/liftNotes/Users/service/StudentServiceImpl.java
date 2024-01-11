package services.liftNotes.Users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.liftNotes.Users.models.User;
import services.liftNotes.Users.repository.UserRepository;

import java.util.List;

@Service
public class StudentServiceImpl  implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByID(Integer userID) {
        return  userRepository.findById(userID).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
