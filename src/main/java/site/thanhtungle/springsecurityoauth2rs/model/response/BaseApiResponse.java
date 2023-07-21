package site.thanhtungle.springsecurityoauth2rs.model.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseApiResponse<T> {

    private int status;
    private T data;
}
