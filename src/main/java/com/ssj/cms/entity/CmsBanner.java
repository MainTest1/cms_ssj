package com.ssj.cms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@TableName("cms_banner")
@Data
public class CmsBanner implements Serializable {
  @TableId(type = IdType.AUTO)
  private Integer id;
  private String bannerImg;
  private String bannerLabel;
  private String bannerDesc;
  @JsonFormat(pattern = "yyyy-MM--dd")
  private Date createDate;

}
