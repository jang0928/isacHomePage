package com.homeDemo.demo.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
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

    @Override
    public List<FileVO> fileListByFK(int questionSeq) {
        return fileRepository.fileListByFK(questionSeq);
    }

    @Override
    public List<FileVO> fileListByPk(List<Integer> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return fileRepository.fileListByPk(list);
    }


    @Override
    public void deleteFileByPk(List<Integer> list) {
        if (CollectionUtils.isEmpty(list)) {
            return ;
        }
        fileRepository.deleteFileByPk(list);
    }

    @Override
    public List<FileVO> fileListByAllDelete(int param) {
        return fileRepository.fileListByAllDelete(param);
    }

    @Override
    public void deleteFileAllByFk(int param) {

        fileRepository.deleteFileAllByFk(param);
    }

    @Override
    public FileVO fileOneBySeq(int seq) {
        return fileRepository.fileOneBySeq(seq);
    }

}
