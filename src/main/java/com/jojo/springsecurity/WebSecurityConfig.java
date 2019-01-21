package com.jojo.springsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("whale").password("{noop}whale").authorities("KAO", "CS").and()
                .withUser("ryu").password("{noop}ryu").authorities("KAO", "BOT").and()
                .withUser("briony").password("{noop}briony").authorities("KAO", "IXP").and()
                .withUser("icebear").password("{noop}icebear").authorities("WBB");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.DELETE, "/snacks/**").hasAuthority("CS")
                .antMatchers("/snacks/**").hasAuthority("KAO")
                .and().formLogin();
    }


}
