package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/logout", "/css/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/dashboard", true)
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = passwordEncoder();  // PasswordEncoder para criptografar as senhas

        UserDetails vendedor = User.builder()
                .username("vendedor")
                .password(encoder.encode("vendedor"))
                .roles("VENDEDOR")
                .build();

        UserDetails funcionario = User.builder()
                .username("funcionario")
                .password(encoder.encode("funcionario"))
                .roles("FUNCIONARIO")
                .build();

        UserDetails administrador = User.builder()
                .username("administrador")
                .password(encoder.encode("administrador"))
                .roles("ADMIN")
                .build();

         new InMemoryUserDetailsManager(vendedor, funcionario, administrador);

            UserDetails admin = User.withUsername("administrador")
                    .password(passwordEncoder().encode("administrador"))
                    .roles("ADMIN")
                    .build();

            return new InMemoryUserDetailsManager(admin);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Encoder para senhas seguras
    }
}
