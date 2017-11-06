package ro.pub.lmn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by radug on 10/31/2017.
 */

@Controller
public class HomeController {
    @GetMapping("")
    public String getHome(){
        return "index";
    }

}
