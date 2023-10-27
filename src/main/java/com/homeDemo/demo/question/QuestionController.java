package com.homeDemo.demo.question;


import com.homeDemo.demo.file.FileVO;
import com.homeDemo.demo.file.FileServiceImpl;
import com.homeDemo.demo.util.EmailService;
import com.homeDemo.demo.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private  FileServiceImpl fileService;
    @Autowired
    private  FileUtil fileUtils;
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
        int rs = questionService.insertQA(questionVO);
//        emailService.sendMailMime(questionVO);
        List<FileVO> files = fileUtils.uploadFiles(questionVO.getFiles());
        fileService.saveFiles(rs,files);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/home/question");
        return mav;
    }
}
