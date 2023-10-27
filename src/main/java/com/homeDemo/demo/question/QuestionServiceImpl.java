package com.homeDemo.demo.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<QuestionVO> getQaList(QuestionVO params, int count) {
        // Pagination 객체를 생성해서 페이지 정보 계산 후 SearchDto 타입의 객체인 params에 계산된 페이지 정보 저장
        Pagenation pagination = new Pagenation(count, params);
        params.setPagination(pagination);
        // 계산된 페이지 정보의 일부(limitStart, recordSize)를 기준으로 리스트 데이터 조회 후 응답 데이터 반환
        List<QuestionVO> list = questionRepository.getQaList(params);
        return list;
    }

    @Override
    public int insertQA(QuestionVO param) {
        questionRepository.insertQA(param);
        return param.getSEQ();
    }

    @Override
    public int qaCount(QuestionVO param) {
        return questionRepository.qaCount(param);
    }

    @Override
    public int qaUpdateContent(QuestionVO param) {
        return questionRepository.qaUpdateContent(param);
    }

    @Override
    public int qaDeleteContent(int param) {
        return questionRepository.qaDeleteContent(param);
    }


    public QuestionVO qaListBySeq(int seq) {
        return questionRepository.qaListBySeq(seq);
    }


}
