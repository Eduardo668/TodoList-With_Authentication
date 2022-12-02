package br.com.todolist.security.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.todolist.models.UserModel;
import br.com.todolist.repository.UserRepository;
import br.com.todolist.util.AlgorithmUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final AlgorithmUtil algorithmUtil;
    private final UserRepository userRepository;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            log.info("USERNAME: "+username);
            log.info("PASSWORD: "+password);

            UsernamePasswordAuthenticationToken authenticationToken = 
                            new UsernamePasswordAuthenticationToken(username, password);
            
            return authenticationManager.authenticate(authenticationToken);   

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authentication) throws IOException, ServletException {
        
            User user = (User)authentication.getPrincipal();
            UserModel user_data = userRepository.findByUsername(user.getUsername());
            System.out.println(user_data.getId().toString());
            List<String> roles = new ArrayList<>();
            user.getAuthorities().stream().forEach(role ->{
                roles.add(role.getAuthority());
            });
            System.out.println(roles);

            String access_token = JWT.create() 
                .withSubject(user_data.getId().toString())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1296000000))
                .withIssuer("Todo list api")
                .withClaim("roles", roles)
                .sign(algorithmUtil.defineAlgorithm());

            String refresh_token = JWT.create()
                .withSubject(user_data.getId().toString())
                .withExpiresAt(new Date(System.currentTimeMillis() + 178758620 * 87))
                .withIssuer("Todo list api")
                .sign(algorithmUtil.defineAlgorithm());

            
            Map<String, String> token = new HashMap<>();
            token.put("access_token", access_token);
            token.put("refresh_token", refresh_token);
            new ObjectMapper().writeValue(response.getOutputStream(), token);
                
            


    }

    
}
