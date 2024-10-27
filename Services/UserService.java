package Services;

import Entities.User;
import Repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
        UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveOneUser(User newuser) {
        return userRepository.save(newuser);
    }

    public User getOneUser(Integer userId) {
        return userRepository.findById(userId).orElse(null);

    }

    public User updateOneUser(Integer userId, User newUser) {
        Optional <User> user = userRepository.findById(userId);
        if(user.isPresent()){
            User foundUser = user.get();
            foundUser.setUsername(newUser.getUsername());
            userRepository.save(foundUser);
            return foundUser;

        }else
            return null;
    }

    public void deleteById(Integer userId) {
        userRepository.deleteById(userId);
    }
}
