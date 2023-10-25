package com.homeDemo.demo.question;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
//    @PostMapping ("/getQA")
//    public String getQuestion (Model model) {
//
//        List<QuestionVO> qaList = questionService.getQaList();
//        model.addAttribute("result",qaList);
//        return "content/home_section";
//    }

    @PostMapping ("/insertQA")
    @ResponseBody
    public ModelAndView insertQuestion (QuestionVO questionVO) {
        QuestionVO param = questionVO;
        int rs =questionService.insertQA(questionVO);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/home/question");
        return mav;
    }
}
