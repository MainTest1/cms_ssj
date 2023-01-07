package com.ssj.cms.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssj.cms.entity.CmsArticles;
import com.ssj.cms.mapper.CmsArticlesMapper;
import com.ssj.cms.service.CmsArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CmsArticlesServiceImpl implements CmsArticlesService {
    @Resource
    private CmsArticlesMapper cmsArticlesMapper;

    @Override
    public IPage<CmsArticles> getCmsArticlesByPage(int current, int size) {
        Page page = new Page();
        page.setCurrent(current);
        page.setSize(size);
        QueryWrapper queryWrapper = new QueryWrapper();
        return cmsArticlesMapper.selectPage(page,queryWrapper);
    }

    @Override
    public void addCmsArticles(CmsArticles cmsArticles) {
        cmsArticlesMapper.insert(cmsArticles);
    }

    @Override
    public void delCmsArticles(String id) {
        cmsArticlesMapper.deleteById(Integer.valueOf(id));
    }

    @Override
    public CmsArticles getCmsArticlesById(String id) {
        return cmsArticlesMapper.selectById(Integer.valueOf(id));
    }

    @Override
    public void updCmsArticles(CmsArticles cmsArticles) {
        cmsArticlesMapper.updateById(cmsArticles);
    }
}
