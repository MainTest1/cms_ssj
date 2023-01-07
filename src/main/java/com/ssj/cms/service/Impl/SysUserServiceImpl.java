package com.ssj.cms.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssj.cms.entity.SysRole;
import com.ssj.cms.entity.SysUser;
import com.ssj.cms.mapper.SysRoleMapper;
import com.ssj.cms.mapper.SysUserMapper;
import com.ssj.cms.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    SysUserMapper sysUserMapper;

    @Resource
    SysRoleMapper sysRoleMapper;

    @Override
    public SysUser getSysUserByUserCode(String userCode) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("user_code",userCode);
        return sysUserMapper.selectOne(queryWrapper);
    }


    @Override
    public IPage<SysUser> getSysUserByPage(int current) {
        Page page = new Page();
        page.setCurrent(current);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("id");
        IPage<SysUser> iPage = sysUserMapper.selectPage(page, queryWrapper);
        List<SysUser> sysUserList = iPage.getRecords();
        for (SysUser sysUser : sysUserList) {
            SysRole sysRole = sysRoleMapper.selectById(sysUser.getRoleId());
            sysUser.setRoleName(sysRole.getRoleName());
        }
        return iPage;
    }

    @Override
    public void addSysUser(SysUser sysUser) {
        sysUserMapper.insert(sysUser);
    }

    @Override
    public void delSysUser(String id) {
        sysUserMapper.deleteById(Integer.valueOf(id));
    }

    @Override
    public SysUser getSysUserById(String id) {
        return sysUserMapper.selectById(Integer.valueOf(id));
    }

    @Override
    public void updSysUser(SysUser sysUser) {
        sysUserMapper.updateById(sysUser);
    }
}
