package site.thanhtungle.springsecurityoauth2rs.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.thanhtungle.springsecurityoauth2rs.model.dto.LoginResponseDTO;
import site.thanhtungle.springsecurityoauth2rs.model.dto.RegistrationDTO;
import site.thanhtungle.springsecurityoauth2rs.model.entity.ApplicationUser;
import site.thanhtungle.springsecurityoauth2rs.service.AuthenticationService;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")
@AllArgsConstructor
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO registrationBody) {
        return authenticationService.registerUser(registrationBody.getUsername(), registrationBody.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }

}
