package site.thanhtungle.springsecurityoauth2rs.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.thanhtungle.springsecurityoauth2rs.model.dto.LoginResponseDTO;
import site.thanhtungle.springsecurityoauth2rs.model.entity.ApplicationUser;
import site.thanhtungle.springsecurityoauth2rs.model.entity.Role;
import site.thanhtungle.springsecurityoauth2rs.repository.RoleRepository;
import site.thanhtungle.springsecurityoauth2rs.repository.UserRepository;
import site.thanhtungle.springsecurityoauth2rs.service.AuthenticationService;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    private AuthenticationManager authenticationManager;

    private TokenServiceImpl tokenService;

    @Override
    public LoginResponseDTO registerUser(String username, String password) throws Exception {

        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);

        ApplicationUser newUser = new ApplicationUser(0, username, encodedPassword, authorities);
        userRepository.save(newUser);

        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);
            return new LoginResponseDTO(newUser, token);
        } catch(AuthenticationException e) {
            throw new Exception("Failed to register. Please try again.");
        }
    }

    public LoginResponseDTO loginUser(String username, String password) throws Exception {

        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);

            return new LoginResponseDTO(userRepository.findByUsername(username).get(), token);

        } catch(AuthenticationException e){
            throw new Exception("Failed to login. Please try again.");
        }
    }
}
