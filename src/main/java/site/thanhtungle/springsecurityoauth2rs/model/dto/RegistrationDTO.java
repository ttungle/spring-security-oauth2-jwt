package site.thanhtungle.springsecurityoauth2rs.model.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationDTO {

    private String username;
    private String password;
    private String passwordConfirm;
}
