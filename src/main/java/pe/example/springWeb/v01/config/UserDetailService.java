package pe.example.springWeb.v01.config;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.example.springWeb.v01.repository.UserRepository; 
import pe.example.springWeb.v01.repository.entity.UserEntity;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsernameAndActive(username, Boolean.TRUE)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", username)));
                
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + userEntity.getRoleEntity().getName());
        return new User(userEntity.getUsername(), userEntity.getPassword(), List.of(authority));
    }

}
