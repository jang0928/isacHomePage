package com.homeDemo.demo.file;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @GetMapping("/question/files/{questionSEQ}")
    public List<FileVO> fileListByFK (@PathVariable final int questionSEQ) {
        return fileService.fileListByFK(questionSEQ);
    }
}

