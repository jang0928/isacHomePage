
package com.homeDemo.demo.question;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionRepository {
    List<QuestionVO> getQaList(QuestionVO param);

    QuestionVO qaListBySeq(int seq);

    void insertQA(QuestionVO param);

    int qaCount(QuestionVO param);

    int qaUpdateContent(QuestionVO param);

    int qaDeleteContent(int param);
}
