package com.codegym;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("hoanglinh").roles("USER")
                .and()
                .withUser("admin").password("admin").roles("ADMIN");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
     http.authorizeRequests().antMatchers("/").permitAll()
             .and()
             .formLogin().loginPage("/login").loginProcessingUrl("/login").successHandler(authenticationSuccessHandler)
             .and()
             .authorizeRequests().antMatchers("/user/**").hasRole("USER")
             .and()
             .authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
             .and()
             .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }
}
