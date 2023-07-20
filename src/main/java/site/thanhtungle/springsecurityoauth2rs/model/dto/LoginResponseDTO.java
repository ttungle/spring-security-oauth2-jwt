package site.thanhtungle.springsecurityoauth2rs.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.thanhtungle.springsecurityoauth2rs.model.entity.ApplicationUser;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginResponseDTO {

    private ApplicationUser user;
    private String accessToken;
}
