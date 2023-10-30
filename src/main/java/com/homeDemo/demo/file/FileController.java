package com.homeDemo.demo.file;

import com.homeDemo.demo.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;
    private final FileUtil fileUtil;

    @GetMapping("/question/files/{questionSEQ}")
    public List<FileVO> fileListByFK (@PathVariable final int questionSEQ) {
        return fileService.fileListByFK(questionSEQ);
    }

    @GetMapping("/question/{questionSEQ}/files/{fileId}/download")
    public ResponseEntity<Resource> downloadFile(@PathVariable final int questionSEQ, @PathVariable final int fileId) {
        FileVO file = fileService.fileOneBySeq(fileId);
        Resource resource = fileUtil.readFileAsResource(file);
        try {
            String filename = URLEncoder.encode(file.getFILE_NAME(), "UTF-8");
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\"" + filename + "\";")
                    .header(HttpHeaders.CONTENT_LENGTH, file.getSIZE() + "")
                    .body(resource);

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("filename encoding failed : " + file.getFILE_NAME());
        }
    }
}

