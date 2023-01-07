package com.ssj.cms.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssj.cms.entity.SysRole;
import com.ssj.cms.mapper.SysRoleMapper;
import com.ssj.cms.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    SysRoleMapper sysRoleMapper;

    @Override
    public IPage<SysRole> getSysRoleByPage(int current) {
        Page page = new Page();
        page.setCurrent(current);
        QueryWrapper wrapper = new QueryWrapper();
        return sysRoleMapper.selectPage(page, wrapper);
    }

    @Override
    public void addSysRole(SysRole sysRole) {
        sysRoleMapper.insert(sysRole);
    }

    @Override
    public void delSysRole(String id) {
        sysRoleMapper.deleteById(Integer.valueOf(id));
    }

    @Override
    public SysRole getSysRoleById(String id) {
        return sysRoleMapper.selectById(Integer.valueOf(id));
    }

    @Override
    public void updSysRole(SysRole sysRole) {
        sysRoleMapper.updateById(sysRole);
    }
}
