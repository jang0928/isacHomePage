
package com.homeDemo.demo.sales;

import com.homeDemo.demo.question.QuestionVO;
import org.apache.ibatis.annotations.Mapper;



import java.util.List;

@Mapper
public interface SalesRepository {
    List<SalesHistoryVO> getSaleList(SalesHistoryVO param);

    SalesHistoryVO saleListBySeq(int seq);

    void insertSale(SalesHistoryVO param);
    int saleCount(SalesHistoryVO param);

    int saleUpdateContent(SalesHistoryVO param);

    int saleDeleteContent(int param);

    int saleTeamCount(SalesHistoryVO param);

    List<SalesHistoryVO> getTeamSaleList(SalesHistoryVO params);
}
