package com.market.domain.service

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl: UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        return User("ale","{noop}pass", ArrayList())
    }

}