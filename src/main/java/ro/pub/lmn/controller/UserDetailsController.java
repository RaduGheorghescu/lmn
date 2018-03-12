package ro.pub.lmn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.pub.lmn.entity.User;
import ro.pub.lmn.service.UserService;

@Controller
@RequestMapping("/user")
public class UserDetailsController {
    private final UserService userService;

    @Autowired
    public UserDetailsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUserDetailsById(@RequestParam Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "userDetails";
    }
}
