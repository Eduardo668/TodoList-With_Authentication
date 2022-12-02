package br.com.todolist.security.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Arrays;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import br.com.todolist.models.UserModel;
import br.com.todolist.repository.UserRepository;
import br.com.todolist.util.AlgorithmUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RequiredArgsConstructor
@Slf4j
public class CustomAuthorizationFilter extends OncePerRequestFilter {

    private final AlgorithmUtil algorithUtil;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        if (request.getServletPath() == "/login" || request.getServletPath() == "/api/user/create"){
            filterChain.doFilter(request, response);
        }

        String authorization_header = request.getHeader(AUTHORIZATION);
        if (authorization_header != null && authorization_header.startsWith("Bearer ")){
            try {
                
                String token_jwt = authorization_header.substring("Bearer ".length());
                System.out.println(token_jwt);
                JWTVerifier verifier = JWT.require(algorithUtil.defineAlgorithm()).build();
                
                DecodedJWT decoded_jwt = verifier.verify(token_jwt);
                String user_id = decoded_jwt.getSubject();
                String[] roles = decoded_jwt.getClaim("roles").asArray(String.class);
                
                Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                Arrays.stream(roles).forEach(role_name ->{
                    authorities.add(new SimpleGrantedAuthority(role_name));
                });
                


                Optional<UserModel> user_data = userRepository.findById(Long.valueOf(user_id));

                UsernamePasswordAuthenticationToken authenticationToken = 
                    new UsernamePasswordAuthenticationToken(user_data.get().getUsername()
                    ,null, authorities);
    
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    
                filterChain.doFilter(request, response);
                
            } catch (Exception e) {
                response.setStatus(403);
                log.error("ERRO 403, FORBIDDEN");
                throw new RuntimeException("ERROR in authorizationFilter", e);
            }
        } else {
            log.info("HEADER NOT FOUND");
            filterChain.doFilter(request, response);
        }



        
    }
    
}
