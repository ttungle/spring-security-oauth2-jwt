package site.thanhtungle.springsecurityoauth2rs.service.jwt;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import site.thanhtungle.springsecurityoauth2rs.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("In the UserDetails Service");

        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User could not be found."));
    }
}
