package com.dhx.config;

import io.jsonwebtoken.*;

import java.util.Date;

public class Jwt {
    private static final String SECRET = "dhx cloud";
    private static final long EXPIRATION_TIME = 2592000000L; //30 * 24 * 60 * 60 * 1000; // 30天

    public static String generateToken(String userId) {
        long now = System.currentTimeMillis();
        Date expiration = new Date(now + EXPIRATION_TIME);

        String token = Jwts.builder()
                .setSubject(userId)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();

        return token;
    }

    public static Verify verifyToken(String token) {
        Verify verify = new Verify();

        try {
            JwtParser parser = Jwts.parser().setSigningKey(SECRET);
            Jws<Claims> claims = parser.parseClaimsJws(token);
            System.out.println("token验证过程中" + claims);
            Date expiration = claims.getBody().getExpiration();


            if (expiration.before(new Date())) {
                System.out.println("Token过期");
                verify.status = false;
                return verify;
            } else {
                System.out.println("Token验证通过");
                verify.status = true;
                verify.userId = claims.getBody().getSubject();
                return verify;
            }
        } catch (SignatureException e) {
            System.out.println("Token验证失败");
            verify.status = false;
            return verify;
        }
    }

}
