package ntnu.stud.tobakken.oving5.controller;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import ntnu.stud.tobakken.oving5.dto.TokenDTO;
import ntnu.stud.tobakken.oving5.entity.User;
import ntnu.stud.tobakken.oving5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthorisationController {

    public static String keyStr = "f8a24295-a964-415f-98ed-f090441c536d";

    @Autowired
    UserRepository userRepository;

    @PostMapping("/token")
    public ResponseEntity<Object> getTokenFromCredentials(@RequestBody Map<String, String> login) throws Exception{
        String username = login.get("username");
        String password = login.get("password");
        System.out.println("Here" + username + password);

        Optional<User> optionalUser = userRepository.findById(username);

        if (optionalUser.isPresent()){
            if (new BCryptPasswordEncoder().matches(password, optionalUser.get().getPassword())){
                String token = generateToken(username);
                System.out.println(token);
                return ResponseEntity.ok(new TokenDTO(token));
            }
        }

        return ResponseEntity.badRequest().body("Wrong credentials");
    }

    public String generateToken(String userId) throws Exception {
        Key key = Keys.hmacShaKeyFor(keyStr.getBytes("UTF-8"));
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        Claims claims = Jwts.claims().setSubject(userId);
        claims.put("userId", userId);
        claims.put("authorities", grantedAuthorities
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));

        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 14400000))
                .signWith(key)
                .compact();
    }

}


