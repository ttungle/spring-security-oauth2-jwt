package site.thanhtungle.springsecurityoauth2rs.service;

import site.thanhtungle.springsecurityoauth2rs.model.entity.ApplicationUser;

public interface AuthenticationService {

    public ApplicationUser registerUser(String username, String password);
}
