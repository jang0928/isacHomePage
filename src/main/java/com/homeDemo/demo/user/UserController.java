package com.homeDemo.demo.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping ("/getUser")
    public String getUser (Model model) {
        List<UserVO> UserList = userService.getUserList();
        model.addAttribute("result",UserList);
        return "content/home_section";
    }

}
