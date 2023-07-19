package site.thanhtungle.springsecurityoauth2rs.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Override
    public ApplicationUser registerUser(String username, String password) {

        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();


        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);


        return userRepository.save(new ApplicationUser(0, username, encodedPassword, authorities));
    }
}
