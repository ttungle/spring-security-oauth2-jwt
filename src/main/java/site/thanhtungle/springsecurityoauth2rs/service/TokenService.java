package site.thanhtungle.springsecurityoauth2rs.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

public interface TokenService {

    public String generateJwt(Authentication authentication);
}
