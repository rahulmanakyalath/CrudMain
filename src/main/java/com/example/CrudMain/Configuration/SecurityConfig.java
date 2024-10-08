package com.example.CrudMain.Configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity //to enable web security
public class SecurityConfig {


    @Bean
    //Authentication
    public UserDetailsService userDetailsService(PasswordEncoder pse) {

        UserDetails admin = User.withUsername("Rahul")
                .password(pse.encode("12345"))
                .roles("ADMIN")
                .build();
        UserDetails user = User.withUsername("Athira")
                .password(pse.encode("123"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin,user);
    }

       @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//
//         http.csrf((csrf) -> csrf.disable());
//               http.requiresChannel(c->c.requestMatchers("/std").requiresInsecure());
//              http.authorizeHttpRequests(request ->{request.requestMatchers().permitAll();
//              request.anyRequest().authenticated();});
//              return http.build();
//    }

    }

