package ro.pub.lmn.controller.api;

import org.springframework.http.HttpRequest;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @GetMapping("/me")
    public Principal getMyUser(Principal principal) {

        return principal;
    }
}
