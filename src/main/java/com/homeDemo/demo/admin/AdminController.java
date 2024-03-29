package com.homeDemo.demo.admin;

import com.homeDemo.demo.file.FileServiceImpl;
import com.homeDemo.demo.file.FileVO;
import com.homeDemo.demo.question.Pagenation;
import com.homeDemo.demo.question.QuestionServiceImpl;
import com.homeDemo.demo.question.QuestionVO;
import com.homeDemo.demo.sales.SalesHistoryVO;
import com.homeDemo.demo.sales.SalesService;
import com.homeDemo.demo.user.UserVO;
import com.homeDemo.demo.util.FileUtil;
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

    private QuestionServiceImpl questionService;
    @Autowired
    private SalesService salesService;
    @Autowired
    private FileUtil fileUtil;
    @Autowired
    private FileServiceImpl fileService;


    @GetMapping("/qa")
    public String goAdminQA(Model model, QuestionVO param , @ModelAttribute("user") UserVO user) {
        model.addAttribute("user",user);
//        return "content/admin/qaTable";
        return "content/admin/salesTable";
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

    @PostMapping("/searchSalesList.ajax")
    @ResponseBody
    public  ModelAndView searchSalesList(Model model , SalesHistoryVO param) {
        ModelAndView mv = new ModelAndView("jsonView");
        int count  = salesService.saleCount(param);
        List<SalesHistoryVO> saleList= salesService.getSaleList(param ,count);
        Pagenation pagination = new Pagenation(count, param);
        mv.addObject("result",saleList );
        mv.addObject("params", pagination);
        return mv;

    }

    @ResponseBody
    @GetMapping("/questionDetail")
    public ModelAndView questionDetail(Model model, @RequestParam("seq") int seq) {
        ModelAndView mv = new ModelAndView("jsonView");
        QuestionVO param = new QuestionVO();
        QuestionVO qaListBySeq = questionService.qaListBySeq(seq);
        mv.addObject("result", qaListBySeq);
        mv.setViewName("content/admin/detailQA");
        return mv;
    }

    @ResponseBody
    @GetMapping("/salesDetail")
    public ModelAndView salesDetail(Model model, @RequestParam("seq") int seq) {
        ModelAndView mv = new ModelAndView("jsonView");
        SalesHistoryVO saleListBySeq = salesService.saleListBySeq(seq);
        mv.addObject("result", saleListBySeq);
        mv.setViewName("content/admin/detailQA");
        return mv;
    }

    @PostMapping ("/insertSale.ajax")
    @ResponseBody
    public ModelAndView insertSale (SalesHistoryVO param) {
        ModelAndView mv = new ModelAndView("jsonView");

        int rs = salesService.insertSale(param);
        mv.addObject("result" , rs);
        return mv;
    }

    @PostMapping ("/updateSale.ajax")
    @ResponseBody
    public ModelAndView updateSale (SalesHistoryVO param) {
        ModelAndView mv = new ModelAndView("jsonView");

        int rs = salesService.saleUpdateContent(param);
        mv.addObject("result" , rs);
        return mv;
    }

    @PostMapping("/updateQA")
    public ModelAndView updateQA(Model model, QuestionVO param) {
        ModelAndView mv = new ModelAndView("jsonView");
        int result =  questionService.qaUpdateContent(param);
        List<FileVO> uploadFiles = fileUtil.uploadFiles(param.getFiles());
        fileService.saveFiles(param.getSEQ(), uploadFiles);
        List<FileVO> deleteFiles = fileService.fileListByPk(param.getRemoveFileIds());

        fileUtil.deleteFiles(deleteFiles);

        fileService.deleteFileByPk(param.getRemoveFileIds());
        mv.setViewName("redirect:/admin/qa");
        return mv;
    }

    @PostMapping("/deleteQA")
    public ModelAndView deleteQA(Model model, @RequestParam("SEQ") int param) {
        ModelAndView mv = new ModelAndView("jsonView");
        int result =  questionService.qaDeleteContent(param);
        // 게시글 seq 로 파일 qusetion_seq 에 넣어서 조회
        List<FileVO> deleteFiles = fileService.fileListByAllDelete(param);

        fileUtil.deleteFiles(deleteFiles);
        fileService.deleteFileAllByFk(param);
        mv.setViewName("redirect:/admin/qa");
        return mv;
    }
}
