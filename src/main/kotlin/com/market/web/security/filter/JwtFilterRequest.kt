package com.market.web.security.filter

import com.market.web.security.JwtUtil
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetails
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtFilterRequest(val jwtUtil: JwtUtil,
                       val userDetailsService: UserDetailsService) : OncePerRequestFilter() {
    override fun doFilterInternal(request: HttpServletRequest,
                                  response: HttpServletResponse,
                                  filterChain: FilterChain) {
        val authorizationHeader: String? = request.getHeader("Authorization")

        if (Objects.nonNull(authorizationHeader) && authorizationHeader!!.startsWith("Bearer")) {
            val jwt = authorizationHeader!!.substring(7)
            val username = jwtUtil.extractUsername(jwt)

            //Valido que en el contexto no exista ninguna autentificacion para el usuario
            if (Objects.nonNull(username) &&
                    Objects.isNull(SecurityContextHolder.getContext().authentication)) {
                val userDetails = userDetailsService.loadUserByUsername(username)

                if (jwtUtil.validateToken(jwt, userDetails)) {
                    val authToken = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
                    authToken.details = WebAuthenticationDetailsSource().buildDetails(request)

                    SecurityContextHolder.getContext().authentication = authToken
                }
            }
        }

        filterChain.doFilter(request, response)
    }
}