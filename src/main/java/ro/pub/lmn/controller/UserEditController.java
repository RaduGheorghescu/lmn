package ro.pub.lmn.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.pub.lmn.entity.dto.UserDTO;
import ro.pub.lmn.enumm.PeopleEnum;
import ro.pub.lmn.service.UserService;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.*;

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
    public String editProfile(@ModelAttribute("user") UserDTO userDTO, Model model, @RequestParam("imagee")MultipartFile image){
        model.addAttribute("userType", this.returnUserTypeList());
        try {
            userDTO.setImage(new SerialBlob(image.getBytes()));
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
//        try {
//            Base64Utils.decodeUrlSafe(userDTO.getImage().getBytes(0, (int) userDTO.getImage().length()));
//            userService.updateUser(userDTO);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return "editUser";
    }
}
