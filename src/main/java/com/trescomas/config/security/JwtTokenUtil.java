package com.trescomas.config.security;

import com.trescomas.config.properties.JwtProperties;
import com.trescomas.domain.model.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenUtil {

    private final Logger log;
    private final JwtProperties jwtProperties;

    public String generateAccessToken(User user) {
        log.debug("Generate access token for user: " + user.getUsername());

        return Jwts.builder()
                .setSubject(String.format("%s,%s", user.getId(), user.getUsername()))
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(new Date())
                .setExpiration(new Date(appendOneWeek(System.currentTimeMillis())))
                .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtProperties.getSecret())))
                .compact();
    }

    public String getUserId(String token) {
        int ID_POSITION = 0;
        return getUserInfo(token, ID_POSITION);
    }

    public String getUsername(String token) {
        int USERNAME_POSITION = 1;
        return getUserInfo(token, USERNAME_POSITION);
    }

    public Date getExpirationDate(String token) {
        return getClaims(token).getExpiration();
    }

    public boolean validate(String token) {
        try {
            getJws(token);
            return true;
        } catch (SignatureException ex) {
            log.error("Invalid JWT signature - {}", ex.getMessage());
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token - {}", ex.getMessage());
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token - {}", ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token - {}", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty - {}", ex.getMessage());
        }
        return false;
    }

    public String getTokenFromHeader(String header) {
        return header.split(" ")[1].trim();
    }

    private String getUserInfo(String token, int position) {
        return getClaims(token)
                .getSubject()
                .split(",")[position];
    }

    private Jws<Claims> getJws(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtProperties.getSecret()).build()
                .parseClaimsJws(token);
    }

    private Claims getClaims(String token) {
        return getJws(token)
                .getBody();
    }

    private long appendOneWeek(long currentMillis) {
        return currentMillis + 7 * 24 * 60 * 60 * 1000;
    }
}
