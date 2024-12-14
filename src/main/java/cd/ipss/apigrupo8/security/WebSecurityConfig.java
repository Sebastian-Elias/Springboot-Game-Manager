package cd.ipss.apigrupo8.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(request->
            request.requestMatchers("api/listar")
            .permitAll()
            .requestMatchers("api/crear")
            .authenticated()
            .requestMatchers("api/buscar/**")
            .authenticated()
        )
        .httpBasic(Customizer.withDefaults())
        .csrf(csrf->csrf.disable());
        return http.build();
    }

    //Usuario temporal creado en memoria para test
    @Bean
    public UserDetailsService testUser(PasswordEncoder passwordEncoder){
        User.UserBuilder user = User.builder();
        UserDetails user1 = user.username("Seba")
        .password(passwordEncoder.encode("123456"))
        .roles()
        .build();
        return new InMemoryUserDetailsManager(user1);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
