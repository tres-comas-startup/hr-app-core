package com.trescomas.config.security;

import com.trescomas.domain.model.user.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class JwtTokenUtil {

    private final int ID_POSITION = 0;

    private final int USERNAME_POSITION = 1;

    private final Logger log;

    @Value("${hrapp.jwtSecret}")
    private String jwtSecret;

    @Value("${hrapp.jwtIssuer:hrapp.io}")
    private String jwtIssuer;

    public JwtTokenUtil(Logger log) {
        this.log = log;
    }

    public String generateAccessToken(User user) {
        log.debug("Generate access token for user: " + user.getUsername());

        return Jwts.builder()
                .setSubject(String.format("%s,%s", user.getId(), user.getUsername()))
                .setIssuer(jwtIssuer)
                .setIssuedAt(new Date())
                .setExpiration(new Date(appendOneWeek(System.currentTimeMillis())))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserId(String token) {
        return getUserInfo(token, ID_POSITION);
    }

    public String getUsername(String token) {
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
                .setSigningKey(jwtSecret).build()
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
