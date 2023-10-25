package com.homeDemo.demo.admin;

import com.homeDemo.demo.question.Pagenation;
import com.homeDemo.demo.question.QuestionServiceImpl;
import com.homeDemo.demo.question.QuestionVO;
import com.homeDemo.demo.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
@SessionAttributes("user")
public class AdminController {
    @Autowired
    QuestionServiceImpl questionService;


    @GetMapping("/qa")
    public String goAdminQA(Model model, QuestionVO param , @ModelAttribute("user") UserVO user) {

        return "content/admin/qaTable";
    }


    @PostMapping("/searchQaList.ajax")
    @ResponseBody
    public  ModelAndView searchQaList(Model model , QuestionVO param) {
        ModelAndView mv = new ModelAndView("jsonView");
        int count  = questionService.qaCount(param);
        List<QuestionVO> qaList= questionService.getQaList(param ,count);
        Pagenation pagination = new Pagenation(count, param);
        mv.addObject("result",qaList );
        mv.addObject("params", pagination);
        return mv;

    }

    @GetMapping("/questionDetail")
    public ModelAndView questionDetail(Model model, @RequestParam("seq") int seq) {
        ModelAndView mv = new ModelAndView("jsonView");
        QuestionVO param = new QuestionVO();
        QuestionVO qaListBySeq = questionService.qaListBySeq(seq);
        mv.addObject("result", qaListBySeq);
        mv.setViewName("/content/admin/detailQA");
        return mv;
    }

    @PostMapping("/updateQA")
    public ModelAndView updateQA(Model model, QuestionVO param) {
        ModelAndView mv = new ModelAndView("jsonView");
        int result =  questionService.qaUpdateContent(param);
        mv.setViewName("redirect:/admin/qa");
        return mv;
    }

    @PostMapping("/deleteQA")
    public ModelAndView deleteQA(Model model, @RequestParam("SEQ") int param) {
        ModelAndView mv = new ModelAndView("jsonView");
        int result =  questionService.qaDeleteContent(param);
        mv.setViewName("redirect:/admin/qa");
        return mv;
    }
}
