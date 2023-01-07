package com.ssj.cms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssj.cms.entity.SysRole;

public interface SysRoleService {
    IPage<SysRole> getSysRoleByPage(int current);

    void addSysRole(SysRole sysRole);

    void delSysRole(String id);

    SysRole getSysRoleById(String id);

    void updSysRole(SysRole sysRole);
}
