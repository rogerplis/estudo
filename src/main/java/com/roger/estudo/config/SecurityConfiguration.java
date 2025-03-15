package com.roger.estudo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;

    private final AuthenticationProvider authenticationProvider;

    private final CustomAuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Desabilita CSRF (se necessário)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/auth/**").permitAll() // Permite acesso público a `/api/auth/**`
                        .requestMatchers("api/v1/admin/**").hasAuthority("ADMIN") // rota q só admin acessa
                        .requestMatchers("api/v1/products/**").hasAuthority("ADMIN")
                        .anyRequest().authenticated() // Requer autenticação para qualquer outra requisição
                )
                .exceptionHandling(ex -> ex.authenticationEntryPoint(authenticationEntryPoint))
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Sem estado
                )
                .authenticationProvider(authenticationProvider) // Define o provedor de autenticação
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class) // Adiciona o filtro JWT antes do padrão
                .build();

    }
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        //Permite requisições de qualquer origem
        //configuration.setAllowedOrigins(List.of("*"));
        //permite apenas origens específicas
        configuration.setAllowedOrigins(List.of("http://localhost:3000")); // Ex: Permitir localhost:3000 (React)
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Métodos permitidos
        configuration.setAllowedHeaders(List.of("*")); // Permitir todos os cabeçalhos
        configuration.setAllowCredentials(true); // Permitir credenciais (cookies, cabeçalhos de autenticação)
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Aplica a configuração a todos os endpoints
        return source;
    }


}
