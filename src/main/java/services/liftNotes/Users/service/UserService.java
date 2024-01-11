package services.liftNotes.Users.service;

import services.liftNotes.Users.models.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public User getUserByID(Integer id);
    public List<User> getAllUsers();


}
