package com.yener.happypoint.config;

import com.yener.happypoint.security.AuthenticationFilter;
import com.yener.happypoint.security.AuthorizationFilter;
import com.yener.happypoint.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.yener.happypoint.security.SecurityConstants.SIGN_UP_URL;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SecurityConfiguration(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //configure(HttpSecurity http) metodu ile hangi URL path’inin herkese açık olacağını
    // hangisinin hangi yetki sahibi kişilerin erişimine açık olacağını kararlaştırıyoruz.
    // Biz burada / path’i yani kök path için herkesin erişimine açık olsun, memberList
    // path’ine sadece ADMIN yetkisi olan kişiler erişebilsin ve httpBasic ile Basic
    // Authentication kullanılsın dedik.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //authenticated olmadan izin veriler urller
        http.authorizeRequests().antMatchers(SIGN_UP_URL).permitAll();
        //http.authorizeRequests().antMatchers("/campaign/**").access("hasRole('ADMIN')");
        //http.authorizeRequests().antMatchers("/company/**").access("hasRole('ADMIN')");
        //http.authorizeRequests().antMatchers("/star/**").access("hasRole('USER')");
        //Herhangi bir request authenticated olmalı
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new AuthenticationFilter(authenticationManager()));
        http.addFilter(new AuthorizationFilter(authenticationManager()));
        //session olusturmayi kaldiriyoruz. Buni JWT ile saglayacagiz.
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    //configure(AuthenticationManagerBuilder auth) metodu ile de user tanımlarımızı yapıyoruz.
    // inMemoryAuthentication() ifadesi user’ların runtime’da tutulduğu ve bir yerlerden çekilip
    // alınmadığı manasına gelir. withUser() metodu ile userName’i, password() metodu ile user’ın
    // parolasını, roles() metodu ile de user’ın rolünü tanımlıyoruz. Biz biri ADMIN biri de USER
    // olacak şekilde iki user tanımladık.
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN")
                .and().withUser("user").password("user").roles("USER");*/
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

}
