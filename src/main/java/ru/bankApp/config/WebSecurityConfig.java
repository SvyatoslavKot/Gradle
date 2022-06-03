package ru.bankApp.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import ru.bankApp.app.entities.Permission;
import ru.bankApp.app.entities.Role;
import ru.bankApp.filter.AdminFilter;
import ru.bankApp.filter.MyFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.BeanProperty;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = { "ru.bankApp.*" })
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterAfter(new MyFilter(), BasicAuthenticationFilter.class)
                .antMatcher("/bank_app/**")

                .csrf()
                    .disable()
                .authorizeRequests()
                .antMatchers("/bank_app/admin/**").hasAuthority(Permission.USER_WRITE.getPermission())
                    .antMatchers("/bank_app/**").permitAll()
                    .antMatchers("/registration").not().fullyAuthenticated()
                    //Все остальные страницы требуют аутентификации
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/bank_app/login/admin")
                    .permitAll()
                    .defaultSuccessUrl("/bank_app/")

                .and()
                    .logout()
                    .permitAll()
                .and()
                    .httpBasic();
    }
/*
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }*/
    @Bean
    public FilterRegistrationBean<MyFilter> myFilterBean(){
        FilterRegistrationBean<MyFilter> myFilterBean = new FilterRegistrationBean<>();
        myFilterBean.setFilter(new MyFilter());
        myFilterBean.addUrlPatterns("/bank_app/client/**");
        return myFilterBean;
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService(){
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("admin")
                        .password(bCryptPasswordEncoder().encode("admin"))
                        .authorities(Role.ADMIN.getAuthorities())
                        .build()
        );
    }


}
