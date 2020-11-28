package com.market.web.controller

import com.market.domain.AuthenticactionRequest
import com.market.domain.AuthenticactionResponse
import com.market.domain.service.UserDetailsServiceImpl
import com.market.web.security.JwtUtil
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(val authenticationManager: AuthenticationManager,
                     val userDetailsServiceImpl: UserDetailsServiceImpl,
                     val jwtUtil: JwtUtil) {

    @PostMapping("/authenticate")
    fun createToken(@RequestBody request: AuthenticactionRequest)
            : ResponseEntity<AuthenticactionResponse> {
        try {
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(request.user, request.pass))
            val userDetails = userDetailsServiceImpl.loadUserByUsername(request.user)
            var jwt = jwtUtil.generateToken(userDetails)
            return ResponseEntity.ok(AuthenticactionResponse(jwt))
        } catch (e: BadCredentialsException) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build()
        }

    }
}