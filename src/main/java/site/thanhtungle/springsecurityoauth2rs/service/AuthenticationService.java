package site.thanhtungle.springsecurityoauth2rs.service;

import site.thanhtungle.springsecurityoauth2rs.model.dto.LoginResponseDTO;

public interface AuthenticationService {

    public LoginResponseDTO registerUser(String username, String password) throws Exception ;

    public LoginResponseDTO loginUser(String username, String password) throws Exception;
}
