package com.homeDemo.demo.HomeController;

import com.homeDemo.demo.user.UserServiceImpl;
import com.homeDemo.demo.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
    @GetMapping("/")
    public String mainHome(Model model) {
        return "redirect:/home";
    }


}
