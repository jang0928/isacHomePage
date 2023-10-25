package com.homeDemo.demo.question;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PagingResponse<T> {
    private List<T> list = new ArrayList<>();
    private Pagenation pagination;

    public PagingResponse(List<T> list, Pagenation pagination) {
        this.list.addAll(list);
        this.pagination = pagination;
    }
}
