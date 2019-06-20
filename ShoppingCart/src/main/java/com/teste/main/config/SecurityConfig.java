package com.teste.main.config;

import com.teste.main.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserServiceImp service;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        //Exige o login com USER ou ADMIN
        //se não, retorna para pagina de login
        http.authorizeRequests()
                .antMatchers("/admin/orderList", "/admin/order", "/admin/accountInfo")
                .access("hasAnyRole('ROLE_EMPLOYEE','ROLE_MANAGER')")
                //pagina apenas para ADMIN
                .antMatchers("/admin/product").access("hasRole('ROLE_MANAGER')")
                //quando login com ROLE_XX, mas a pagina requer ROLE_YY
                //um AccessDeniedException sera chamado
                .and().exceptionHandling().accessDeniedPage("/403")
                //formulario de login
                .and().formLogin()
                .loginProcessingUrl("/j_spring_check")
                .loginPage("/admin/login")
                .defaultSuccessUrl("/admin/accountInfo")
                .failureUrl("/admin/login?error=true")
                .usernameParameter("userName")
                .passwordParameter("password")
                //pagina de logout(seguir para pagina home)
                .and().logout().logoutUrl("/admin/logout").logoutSuccessUrl("/");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //Ajusta o service para encontrar o usuario no BD
        //Ajusta o PasswordEncoder
        auth.userDetailsService(service).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

}
