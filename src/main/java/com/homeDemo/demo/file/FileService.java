package com.homeDemo.demo.file;

import java.util.List;

public interface FileService {
    public void saveFiles(int questionSeq, List<FileVO> files);
    public List<FileVO> fileListByFK(int questionSeq);

    public  List<FileVO> fileListByPk(List<Integer> list);

    public void deleteFileByPk(List<Integer> list);

    List<FileVO> fileListByAllDelete(int param);

    void deleteFileAllByFk(int param);

    public FileVO fileOneBySeq(int seq);
}
