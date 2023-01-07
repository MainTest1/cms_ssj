package com.ssj.cms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("sys_user")
@Data
public class SysUser implements Serializable {

  @TableId(type = IdType.AUTO)
  private Integer id;
  private String userCode;
  private String userName;
  private String userPwd;
  private String userImg;
  private Integer roleId;

  @TableField(exist = false)
  private String roleName;
}
