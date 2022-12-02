package br.com.todolist.services.user_service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.todolist.models.UserModel;
import br.com.todolist.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository; 
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel user_data = userRepository.findByUsername(username);

        if (user_data == null) {
            throw new UsernameNotFoundException("This user don't exists");
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        user_data.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        User user_details = new User(
                user_data.getUsername(), user_data.getPassword(), authorities);

        return user_details;

    }

    
}
