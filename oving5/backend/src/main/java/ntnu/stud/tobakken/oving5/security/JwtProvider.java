package ntnu.stud.tobakken.oving5.security;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import ntnu.stud.tobakken.oving5.dto.TokenDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtProvider {
    @Value("f8a24295-a964-415f-98ed-f090441c536d")
    private String secret;

    @Value("14400000")
    private int expirationMs;

    public String generateToken(Authentication auth){
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

        Date now = new Date();
        Date expiry = new Date(now.getTime() + expirationMs);

        return Jwts.builder()
                .setSubject(auth.getName())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(key)
                .compact();

    }

    public Boolean validateToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
        JwtParser parser = Jwts.parserBuilder().setSigningKey(key).build();

        try {
            parser.parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
