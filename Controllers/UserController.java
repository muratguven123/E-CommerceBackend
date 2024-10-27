package Controllers;

import Entities.User;
import Repos.UserRepository;
import Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    private UserService userServices;
    private UserRepository userservices;
    public UserController(UserService userServices){//Constructor İnjection
        this.userServices = userServices;
    }
    @GetMapping
    public List<User> getAllUsers(){
            return userServices.getAllUsers();
    }
    @PostMapping
    public User createUser(@RequestBody User newuser){
        return userServices.saveOneUser(newuser);
    }
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Integer userId){
        //Costum Exception
        return userServices.getOneUser(userId);

    }
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Integer userId,@RequestBody User newUser){
       return userServices.updateOneUser(userId,newUser);
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId){
        userServices.deleteById(userId);
    }
}
