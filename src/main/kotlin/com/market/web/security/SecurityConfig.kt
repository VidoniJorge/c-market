package com.market.web.security

import com.market.domain.service.UserDetailsServiceImpl
import com.market.web.security.filter.JwtFilterRequest
import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@EnableWebSecurity
class SecurityConfig(val service: UserDetailsServiceImpl,
                     val jwtFilterRequest: JwtFilterRequest) : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.userDetailsService(service)
    }

    override fun configure(http: HttpSecurity?) {
        http!!.csrf().disable() //desabilitamos las peticiones crusadas
                .authorizeRequests() //autorice las peticiones
                .antMatchers("/**/authenticate").permitAll() // que permita todas las peticiones que terminen en authenticate
                .anyRequest().authenticated() // el resto de las peticiones se tienen que validar
                //Indicamos que la session es stateless osea sin sesión, porque los json web token son los que controlaran cada petición particular sin manejar una sesión como tal
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http!!.addFilterBefore(jwtFilterRequest,UsernamePasswordAuthenticationFilter::class.java)
    }

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }
}




