package site.thanhtungle.springsecurityoauth2rs.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.thanhtungle.springsecurityoauth2rs.model.dto.LoginResponseDTO;
import site.thanhtungle.springsecurityoauth2rs.model.dto.RegistrationDTO;
import site.thanhtungle.springsecurityoauth2rs.model.response.BaseApiResponse;
import site.thanhtungle.springsecurityoauth2rs.service.AuthenticationService;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")
@AllArgsConstructor
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<BaseApiResponse<LoginResponseDTO>>
    registerUser(@RequestBody RegistrationDTO registrationBody) throws Exception {

        if (!registrationBody.getPassword().equals(registrationBody.getPasswordConfirm())) {
            throw new Exception("The confirm password does not match");
        }

        LoginResponseDTO registerResponse = authenticationService
                .registerUser(registrationBody.getUsername(), registrationBody.getPassword());
        BaseApiResponse<LoginResponseDTO> baseApiResponse = new BaseApiResponse<>();
        baseApiResponse.setStatus(HttpStatus.OK.value());
        baseApiResponse.setData(registerResponse);

        return new ResponseEntity<>(baseApiResponse, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<BaseApiResponse<LoginResponseDTO>> loginUser(@RequestBody RegistrationDTO body) throws Exception {

        LoginResponseDTO loginResponse = authenticationService.loginUser(body.getUsername(), body.getPassword());
        BaseApiResponse<LoginResponseDTO> baseApiResponse = new BaseApiResponse();
        baseApiResponse.setStatus(HttpStatus.OK.value());
        baseApiResponse.setData(loginResponse);

        return new ResponseEntity<>(baseApiResponse, HttpStatus.OK);
    }

}
