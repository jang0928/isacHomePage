package com.homeDemo.demo.sales;

import com.homeDemo.demo.question.Pagenation;
import com.homeDemo.demo.question.QuestionRepository;
import com.homeDemo.demo.question.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    private SalesRepository salesRepository;

    @Override
    public List<SalesHistoryVO> getSaleList(SalesHistoryVO params, int count) {
        Pagenation pagination = new Pagenation(count, params);
        params.setPagination(pagination);
        // 계산된 페이지 정보의 일부(limitStart, recordSize)를 기준으로 리스트 데이터 조회 후 응답 데이터 반환
        List<SalesHistoryVO> list = salesRepository.getSaleList(params);
        return list;
    }

    @Override
    public List<SalesHistoryVO> getTeamSaleList(SalesHistoryVO params, int count) {
        Pagenation pagination = new Pagenation(count, params);
        params.setPagination(pagination);
        // 계산된 페이지 정보의 일부(limitStart, recordSize)를 기준으로 리스트 데이터 조회 후 응답 데이터 반환
        List<SalesHistoryVO> Teamlist = salesRepository.getTeamSaleList(params);
        return Teamlist;
    }

    @Override
    public SalesHistoryVO saleListBySeq(int seq) {
        return null;
    }

    @Override
    public int insertSale(SalesHistoryVO param) {
        salesRepository.insertSale(param);
        return param.getSALE_SEQ();
    }

    @Override
    public int saleCount(SalesHistoryVO param) {
        return salesRepository.saleCount(param);
    }

    @Override
    public int saleTeamCount(SalesHistoryVO param) {
        return salesRepository.saleTeamCount(param);
    }

    @Override
    public int saleUpdateContent(SalesHistoryVO param) {
        return salesRepository.saleUpdateContent(param);
    }

    @Override
    public int saleDeleteContent(int param) {
        return salesRepository.saleDeleteContent(param);
    }
}
