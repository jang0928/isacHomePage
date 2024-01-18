package com.homeDemo.demo.HomeController;

import com.homeDemo.demo.user.UserServiceImpl;
import com.homeDemo.demo.user.UserVO;
import com.homeDemo.demo.util.EmailService;
import jakarta.annotation.Resource;
import jakarta.annotation.Resources;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/home")
@SessionAttributes("user")
@Slf4j
public class HomeController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    EmailService emailService;
    @GetMapping()
    public String mainHome(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String id =  String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        UserVO userVO = userService.getUserById(id);

        model.addAttribute("user",userVO);
        return "redirect:/admin/qa";
    }
    @GetMapping("/login")
    public String loginPage() { // 로그인되지 않은 상태이면 로그인 페이지를, 로그인된 상태이면 home 페이지를 보여줌
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return "content/home/login_page";
        }
        return "redirect:/home";
    }

    @GetMapping("/about")
    public String goAbout(Model model) {
      //  model.addAttribute("hi", "world");
        return "content/home/about";
    }
    @GetMapping("/introduce")
    public String goIntroduce(Model model) {
        //  model.addAttribute("hi", "world");
        return "content/home/introduce";
    }

    @GetMapping("/question")
    public String goQuestion() {
        //  model.addAttribute("hi", "world");
        return "content/home/contact";
    }

    @GetMapping("/services")
    public String goServices() {
        //  model.addAttribute("hi", "world");
        return "content/home/services";
    }



}
