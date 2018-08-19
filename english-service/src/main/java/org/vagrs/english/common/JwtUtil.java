package org.vagrs.english.common;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClock;

import java.util.Date;
import java.util.function.Function;

/**
 * Created by Kirill Zhitelev on 30.05.2018.
 */
public final class JwtUtil {
    private final static Clock clock = DefaultClock.INSTANCE;

    public static String generateToken(String userName) {
        final Date createDate = clock.now();
        return Jwts.builder()
                .setSubject(userName)
                .setExpiration(new Date(createDate.getTime() + Long.parseLong(Constants.TOKEN_TIME)))
                .setIssuedAt(createDate)
                .signWith(SignatureAlgorithm.HS512, Constants.SECRET.getBytes())
                .compact();
    }

    public static String refreshToken(String userName) {
        return generateToken(userName);
    }

    public static String getSubject(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public static Date getExpirationDate(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public static Date getCreateDate(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    public static boolean isTokenExpired(String token) {
        try {
            return clock.now().after(getExpirationDate(token));
        } catch (ExpiredJwtException e) {
            return true;
        }
    }

    private static <T> T getClaimFromToken(String token, Function<Claims, T> getClaim) {
        return getClaim.apply(getAllClaims(token));
    }

    private static Claims getAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(Constants.SECRET.getBytes())
                .parseClaimsJws(token)
                .getBody();
    }
}
