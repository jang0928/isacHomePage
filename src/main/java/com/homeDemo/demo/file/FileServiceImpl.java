package com.homeDemo.demo.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileRepository fileRepository;

    @Override
    public void saveFiles(int questionSeq, List<FileVO> files) {
        if (CollectionUtils.isEmpty(files)) {
            return;
        }
        for (FileVO file : files) {
            file.setQUESTION_SEQ(questionSeq);
        }
        fileRepository.saveFileAll(files);
    }
}
