package ntnu.stud.tobakken.oving5.controller;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import ntnu.stud.tobakken.oving5.dto.TokenDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthorisationController {

    public static String keyStr = "f8a24295-a964-415f-98ed-f090441c536d";

    @PostMapping("/token")
    public ResponseEntity<TokenDTO> getTokenFromCredentials(@RequestBody Map<String, String> login) throws Exception{
        String username = login.get("username");
        String password = login.get("password");
        System.out.println("Here" + username + password);

        if (username.equals("tobakken") && password.equals("qwer1234")){
            String token = generateToken(username);
            System.out.println(token);
            return ResponseEntity.ok(new TokenDTO(token));
        }
        return null;
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


