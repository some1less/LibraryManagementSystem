package some1less.librarymanagsys.controller;

import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/users")
    User newUser(@RequestBody User newUser){

        return userRepository.save(newUser);

    }

    @PutMapping("/users/{id}")
    User modifyUser(@RequestBody User newUser, @PathVariable int id){

        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setPhoneNumber(newUser.getPhoneNumber());
                    user.setAddress(newUser.getAddress());
                    return userRepository.save(user);
                }).orElseGet(() -> {
                    return userRepository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable int id){

        userRepository.deleteById(id);
    }


}
