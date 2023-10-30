
package com.homeDemo.demo.file;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileRepository {
    void saveFileAll(List<FileVO> files);
    List<FileVO> fileListByFK(int questionSeq);
    List<FileVO> fileListByPk(List<Integer> list);
    void deleteFileByPk(List<Integer> list);

    List<FileVO> fileListByAllDelete(int param);

    void deleteFileAllByFk(int param);

    FileVO fileOneBySeq(int seq);
}
