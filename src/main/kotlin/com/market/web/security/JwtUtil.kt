package com.market.web.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*

const val KEY: String = "PassWord01"

@Component
class JwtUtil {

    fun generateToken(userDetails: UserDetails): String {
        return Jwts.builder()
                .setSubject(userDetails.username)
                .setIssuedAt(Date())
                .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, KEY)
                .compact()
    }

    fun validateToken(jwt: String, userDetails: UserDetails): Boolean {
        return userDetails.username.equals(extractUsername(jwt)) && !isExpired(jwt)
    }

    fun extractUsername(jwt: String): String {
        return getClaims(jwt).subject
    }

    fun isExpired(jwt: String): Boolean {
        return getClaims(jwt).expiration.before(Date())
    }

    fun getClaims(jwt: String): Claims {
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(jwt).body
    }
}