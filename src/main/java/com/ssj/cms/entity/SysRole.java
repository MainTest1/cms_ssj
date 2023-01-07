package com.ssj.cms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("sys_role")
@Data
public class SysRole implements Serializable {

  @TableId(type = IdType.AUTO)
  private Integer id;
  private String roleName;
}
