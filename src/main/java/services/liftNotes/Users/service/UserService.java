package services.liftNotes.Users.service;

import services.liftNotes.Users.models.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();


}
