package com.homeDemo.demo.question;

import lombok.Data;

import java.util.Date;


@Data
public class SalesHistoryVO extends PaigingVO {
    private int SALE_SEQ;
    private String NAME;
    private Integer SALE_CNT;
    private Float PRICE;
    private Float PROFIT;
    private String STATE;
    private String REG_ID;
    private Date REG_DT;
    private Date LST_MOD_DT; // Char(8)를 그대로 String으로 사용
    private String LST_MOD_ID;
}
