package br.com.todolist.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.com.todolist.repository.UserRepository;
import br.com.todolist.security.filter.CustomAuthenticationFilter;
import br.com.todolist.security.filter.CustomAuthorizationFilter;
import br.com.todolist.services.user_service.CustomUserDetailsService;
import br.com.todolist.util.AlgorithmUtil;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig{

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AlgorithmUtil algorithmUtil;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        CustomAuthenticationFilter customAuthenticationFilter = 
            new CustomAuthenticationFilter(authenticationManager(null) 
            , algorithmUtil, userRepository);

            CustomAuthorizationFilter customAuthorizationFilter = new CustomAuthorizationFilter(algorithmUtil, userRepository);


        http.csrf().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.cors().and().authorizeHttpRequests(request ->{
            request.requestMatchers(HttpMethod.GET,
            "/api/user/findall", 
            "/api/user/findUserById/**").hasAnyAuthority("ROLE_USER");

            request.requestMatchers(HttpMethod.POST, "/api/user/create", "/login").permitAll();

            request.requestMatchers(HttpMethod.DELETE, "/api/user/delete/**")
            .hasAnyAuthority("ROLE_USER");

            request.requestMatchers(HttpMethod.PUT,
             "/api/user/add-task/**",
             "/api/user/update/**")
             .hasAnyAuthority("ROLE_USER");
        });

        http.authorizeHttpRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(customAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    // 
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        
        CustomUserDetailsService customUserDetails = new CustomUserDetailsService(userRepository);
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetails);
        authProvider.setPasswordEncoder(passwordEncoder);

        return authProvider;

    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Authorization", "Access-Control-Allow-Origin", "Content-Type"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE"));
    
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    
    }   




}