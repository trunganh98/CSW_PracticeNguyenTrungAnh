package com.example.csw_practice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class CustomerConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth){
        try{
            auth.inMemoryAuthentication()
                    .withUser("user").password("{noop}123456").roles("CUSTOMER")
                    .and()
                    .withUser("admin").password("{noop}123456").roles("STAFF");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/**").hasAnyRole("STAFF")
                .antMatchers(HttpMethod.PUT, "/api/**").hasAnyRole("CUSTOMER")
                .antMatchers(HttpMethod.DELETE, "/api/**").hasAnyRole("STAFF")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf()
                .ignoringAntMatchers("/api/**");
    }
}
