package site.thanhtungle.springsecurityoauth2rs.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.thanhtungle.springsecurityoauth2rs.model.entity.ApplicationUser;

@Service
@Transactional
public interface AuthenticationService {

    public ApplicationUser registerUser(String username, String password);
}
