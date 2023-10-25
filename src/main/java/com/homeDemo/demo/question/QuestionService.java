package com.homeDemo.demo.question;


import java.util.List;

public  interface QuestionService  {
    public List<QuestionVO> getQaList(QuestionVO param, int count);
    public QuestionVO qaListBySeq(int seq);

   public  int insertQA(QuestionVO param);

   public int qaCount(QuestionVO param);
}
