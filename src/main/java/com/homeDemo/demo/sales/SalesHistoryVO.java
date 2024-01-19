package com.homeDemo.demo.sales;

import com.homeDemo.demo.util.PaigingVO;
import lombok.Data;

import java.util.Date;


@Data
public class SalesHistoryVO extends PaigingVO {
    private int SALE_SEQ;
    private String NAME;
    private String TEAM_NAME;
    private Integer SALE_CNT;
    private Float PRICE;
    private Float PROFIT;
    private Integer SUMCNT;
    private Float SUMPRICE;
    private Float SUMPROFIT;
    private String STATE;
    private String REG_ID;
    private String  REG_DT;
    private String LST_MOD_DT; // Char(8)를 그대로 String으로 사용
    private String LST_MOD_ID;
}
