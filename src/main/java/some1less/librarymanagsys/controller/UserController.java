package some1less.librarymanagsys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import some1less.librarymanagsys.exception.UserNotFoundException;
import some1less.librarymanagsys.model.User;
import some1less.librarymanagsys.repository.UserRepository;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    List<User> all(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    User getUser(@PathVariable int id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
