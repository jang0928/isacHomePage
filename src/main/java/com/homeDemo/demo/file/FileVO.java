package com.homeDemo.demo.file;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FileVO {
    private int SEQ;
    private int QUESTION_SEQ;
    private String FILE_ID;
    private String FILE_NAME; //ORIGIN
    private long SIZE;
    private String DELETE_YN;
    private String REG_DT;
    private String DELETED_DT;

}
