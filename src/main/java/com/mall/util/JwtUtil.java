package com.mall.util;

import com.mall.dto.CartRequestDto;
import com.mall.entities.Cart;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.naming.ldap.HasControls;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {
    private String SECRET_KEY = "secret";

    public String extractUserName(String token){
        return extractClaim(token,Claims::getSubject);
    }
    public Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);

    }
    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims= extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    public String generateToken(CartRequestDto cart){
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims,cart.getName());
    }
    public String createToken(Map<String,Object>claims,String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+1000*60*60*1))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }
    public boolean validateToken(String token,Cart cart){
        final String username = extractUserName(token);
        return (username.equals(cart.getName()) && !isTokenExpired(token));
    }
}
