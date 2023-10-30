package com.homeDemo.demo.question;

import com.homeDemo.demo.util.PaigingVO;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionVO extends PaigingVO {
    private int SEQ;
    private String SUBJECT;
    private String COMPANY_NM;
    private String MB_NM;
    private String CELPNO;
    private String EMAIL_ADDR;
    private String REG_ID;
    private String REG_DT;
    private String LST_MOD_DT;
    private String LST_MOD_ID;
    private String MESSAGE;
    private String AUTH;
    private List<MultipartFile> files = new ArrayList<>();
    private List<Integer> removeFileIds = new ArrayList<>();     // 삭제할 첨부파일 id List
//    private int page;                 // 현재 페이지 번호
//    private int recordSize;           // 페이지당 출력할 데이터 개수
//    private int pageSize;             // 화면 하단에 출력할 페이지 사이즈
//    private String keyword;           // 검색 키워드
//    private String searchType;        // 검색 유형
//    private Pagenation pagination;


}
