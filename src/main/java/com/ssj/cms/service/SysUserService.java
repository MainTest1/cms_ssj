package com.ssj.cms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssj.cms.entity.SysUser;

public interface SysUserService {
    SysUser getSysUserByUserCode(String userCode);
    IPage<SysUser> getSysUserByPage(int current);
    void addSysUser(SysUser sysUser);
    void delSysUser(String id);

    SysUser getSysUserById(String id);

    void updSysUser(SysUser sysUser);
}
