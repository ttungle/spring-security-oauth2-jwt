package site.thanhtungle.springsecurityoauth2rs.model.response;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponseWithoutData {
    private int status;
    private String message;
}
