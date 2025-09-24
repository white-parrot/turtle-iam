package rt.turtleIam.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rt.turtleIam.dto.UserDto;
import rt.turtleIam.entity.TurtleUser;
import rt.turtleIam.repository.TurtleUserRepository;

@RestController
@RequiredArgsConstructor
public class TurtleUserController {

    private final TurtleUserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/public/register")
    public ResponseEntity<String> createUser(@RequestBody UserDto user) {
        TurtleUser turtleUser = TurtleUser.builder()
                .email(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .active(user.isEnabled())
                .role(user.getAuthority())
                .build();
        repository.save(turtleUser);
        return ResponseEntity.ok("User is created");
    }
}
