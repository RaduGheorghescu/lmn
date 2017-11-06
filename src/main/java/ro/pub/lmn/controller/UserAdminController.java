package ro.pub.lmn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.pub.lmn.entity.User;
import ro.pub.lmn.service.UserService;

/**
 * Created by radug on 10/31/2017.
 */
@Controller
@RequestMapping("/admin/users")
public class UserAdminController {
    private final UserService userService;
    @Autowired
    public UserAdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getUserList(Model model){
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @GetMapping("/add")
    public String addUser(Model model){
        model.addAttribute("user",new User());
        return "addUser";
    }
    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user){
        if(userService.findByEmail(user.getEmail()) != null){
            return "redirect:/admin/users";
        }
        userService.addUser(user);
        return "redirect:/admin/users";
    }
}
