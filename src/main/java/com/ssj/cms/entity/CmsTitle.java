package com.ssj.cms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@TableName("cms_title")
@Data
public class CmsTitle implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String titleName;
    private String titleStyle;
    private Integer titlePid;

    @TableField(exist = false)
    private String titlePidName;

    @TableField(exist = false)
    private List<CmsTitle> childList;


}
