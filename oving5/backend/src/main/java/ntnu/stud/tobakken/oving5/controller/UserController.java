package ntnu.stud.tobakken.oving5.controller;


import ntnu.stud.tobakken.oving5.dto.UserDTO;
import ntnu.stud.tobakken.oving5.entity.User;
import ntnu.stud.tobakken.oving5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody Map<String, String> userinfo) {
        String username = userinfo.get("username");
        String encryptedPw = new BCryptPasswordEncoder().encode(userinfo.get("password"));

        User user = new User(username, encryptedPw);
        userRepository.save(user);
        return ResponseEntity.ok(new UserDTO(user) + " Added to the database");
    }
}
