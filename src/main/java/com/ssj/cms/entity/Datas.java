package com.ssj.cms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Datas {
    private Integer pageNum;
    private Integer pageSize;
    private Integer pageTotal;
    private Integer pageCount;
    private List<Student> studentList;
}
