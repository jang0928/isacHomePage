
package com.homeDemo.demo.file;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileRepository {
    void saveFileAll(List<FileVO> files);
}
