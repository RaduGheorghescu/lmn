package ro.pub.lmn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.pub.lmn.entity.dto.UserDTO;
import ro.pub.lmn.enumm.PeopleEnum;
import ro.pub.lmn.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by radug on 11/1/2017.
 */

@Controller
@RequestMapping("/my")
public class UserEditController {
    private final UserService userService;

    @Autowired
    public UserEditController(UserService userService) {
        this.userService = userService;
    }

    private List<String> returnUserTypeList(){
        List<String> userType = new ArrayList<>();
        EnumSet.allOf(PeopleEnum.class).forEach(people -> userType.add(people.toString()));
        return userType;
    }

    @GetMapping("/profile")
    public String editProfile(Principal principal, Model model){
        UserDTO userDTO = new UserDTO();
        userDTO.toUserDTO(userService.findByEmail(principal.getName()));
        model.addAttribute("userType", this.returnUserTypeList());
        model.addAttribute("user", userDTO);
        return "editUser";
    }

    @PostMapping("/profile")
    public String editProfile(@ModelAttribute("user") UserDTO userDTO, Model model){
        model.addAttribute("userType", this.returnUserTypeList());
        userService.updateUser(userDTO);
        return "editUser";
    }
}
