package com.ssj.cms.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@TableName("cms_articles")
@Data
public class CmsArticles implements Serializable {
  @TableId(type = IdType.AUTO)
  private Integer id;
  private String articleTitle;
  private Integer userId;
  private Date createDate;
  private String articleImg;
  private String articleLabel;
  private String articleIntro;
  private byte[] articleContent;
  private Integer titleId;

  @TableField(exist = false)
  private String articleContentStr;
}
