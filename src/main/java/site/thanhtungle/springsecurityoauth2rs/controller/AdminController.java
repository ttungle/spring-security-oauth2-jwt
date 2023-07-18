package site.thanhtungle.springsecurityoauth2rs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.thanhtungle.springsecurityoauth2rs.model.response.BaseResponseWithoutData;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin
public class AdminController {

    @GetMapping("")
    public ResponseEntity<BaseResponseWithoutData> helloAdminController() {
        BaseResponseWithoutData resBody = new BaseResponseWithoutData(HttpStatus.OK.value(), "Admin access level");

        return ResponseEntity.ok().body(resBody);
    }
}
