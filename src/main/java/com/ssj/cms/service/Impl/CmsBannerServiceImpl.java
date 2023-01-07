package com.ssj.cms.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssj.cms.entity.CmsBanner;
import com.ssj.cms.entity.SysRole;
import com.ssj.cms.mapper.CmsBannerMapper;
import com.ssj.cms.service.CmsBannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CmsBannerServiceImpl implements CmsBannerService {

    @Resource
    CmsBannerMapper cmsBannerMapper;

    @Override
    public IPage<CmsBanner> getCmsBannerByPage(int current, int size) {
        Page page = new Page(current,size);
        QueryWrapper wrapper = new QueryWrapper();
        return cmsBannerMapper.selectPage(page, wrapper);
    }

    @Override
    public void addCmsBanner(CmsBanner cmsBanner) {
        cmsBannerMapper.insert(cmsBanner);

    }

    @Override
    public void delCmsBanner(String id) {
        cmsBannerMapper.deleteById(Integer.valueOf(id));
    }

    @Override
    public CmsBanner getCmsBannerById(String id) {
        return cmsBannerMapper.selectById(Integer.valueOf(id));
    }

    @Override
    public void updCmsBanner(CmsBanner cmsBanner) {
        cmsBannerMapper.updateById(cmsBanner);
    }
}
