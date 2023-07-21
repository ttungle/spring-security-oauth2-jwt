package site.thanhtungle.springsecurityoauth2rs.service;

import org.springframework.security.core.Authentication;

public interface TokenService {

    public String generateJwt(Authentication authentication);
}
