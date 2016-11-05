package com.crimelab.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
		.usersByUsernameQuery(
			"select username,password,enabled from cldb_users where username=?")
		.authoritiesByUsernameQuery(
			"select username, role from cldb_userroles where username=?");
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            return encoder;
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
                .antMatchers("/css/**", "/js/**", "/img/**", "/fonts/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
              .antMatchers("/","/login**","/register**").permitAll()
              .antMatchers("/siteadmin/**").access("hasRole('ROLE_ADMIN')")
              .anyRequest().authenticated()
            .and()
              .formLogin().loginPage("/login").failureUrl("/login?error")
              .usernameParameter("username").passwordParameter("password")
            .and()
              .logout().logoutSuccessUrl("/login?logout")
              .deleteCookies( "JSESSIONID" ).invalidateHttpSession( true )
            .and()
              .exceptionHandling().accessDeniedPage("/403")
            .and()
              .csrf();
        

    }
}
