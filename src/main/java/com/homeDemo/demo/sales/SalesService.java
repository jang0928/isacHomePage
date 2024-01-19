package com.homeDemo.demo.sales;


import com.homeDemo.demo.sales.SalesHistoryVO;

import java.util.List;

public  interface SalesService {
    public List<SalesHistoryVO> getSaleList(SalesHistoryVO param, int count);
    public List<SalesHistoryVO> getTeamSaleList(SalesHistoryVO param, int count);
    public SalesHistoryVO saleListBySeq(int seq);

   public  int insertSale(SalesHistoryVO param);

   public int saleCount(SalesHistoryVO param);

   public int saleTeamCount(SalesHistoryVO param);

    public int saleUpdateContent(SalesHistoryVO param);

    int saleDeleteContent(int param);
}
