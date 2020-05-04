package com.hoanglinh.configuration;

import com.hoanglinh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;
    @Override
    protected void configure(HttpSecurity httpSecurity){
      httpSecurity.authorizeRequests()
              .antMatchers("/user/**").access("hasRole('role_user')")
              .antMatchers("/admin/**").access("hasRole('role_admin')")
              .antMatchers("/home/**").access("hasAnyRole('role_user','role_admin')")
              .antMatchers("/dba/**").access("hasRole('role_admin') and hasRole('role_dba')")
              .and().formLogin().loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/")
              .failureUrl("/login?error")
              .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
              .logoutSuccessUrl("/signout")
              .and().csrf().disable();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth){
       auth.userDetailsService((UserDetailsService) userService )
               .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

}
