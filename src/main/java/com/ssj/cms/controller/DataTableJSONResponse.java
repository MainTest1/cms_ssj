package com.ssj.cms.controller;

import lombok.Data;

import java.util.List;

@Data
public class DataTableJSONResponse {
    Integer draw = 1;
    Long recordsTotal = 0l; //查询的记录数
    Long recordsFiltered = 0l; //过滤后的记录数
    List data;
    public DataTableJSONResponse(List aaData) {
        this.data = aaData;
    }
}
