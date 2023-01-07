package com.ssj.cms.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssj.cms.entity.CmsTitle;
import com.ssj.cms.mapper.CmsTitleMapper;
import com.ssj.cms.service.CmsTitleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CmsTitleServiceImpl implements CmsTitleService {

    @Resource
    CmsTitleMapper cmsTitleMapper;

    @Override
    public IPage<CmsTitle> getCmsTitleByPage(int current) {
        Page page = new Page();
        page.setCurrent(current);
        QueryWrapper queryWrapper = new QueryWrapper();
        IPage<CmsTitle> iPage = cmsTitleMapper.selectPage(page, queryWrapper);
        List<CmsTitle> cmsTitleList = iPage.getRecords();
        for (CmsTitle cmsTitle : cmsTitleList) {
            if(cmsTitle.getTitlePid()==0){
                cmsTitle.setTitlePidName("一级标题");
            }else {
                CmsTitle cmsTitlePrent = cmsTitleMapper.selectById(cmsTitle.getTitlePid());
                cmsTitle.setTitlePidName(cmsTitlePrent.getTitleName());
            }
        }
        return iPage;
    }

    @Override
    public void addCmsTitle(CmsTitle cmsTitle) {
        cmsTitleMapper.insert(cmsTitle);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delCmsTitle(String id) {
        cmsTitleMapper.deleteById(Integer.valueOf(id));
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("title_pid",Integer.valueOf(id));
        cmsTitleMapper.delete(queryWrapper);
    }

    @Override
    public CmsTitle getCmsTitleById(String id) {
        return cmsTitleMapper.selectById(Integer.valueOf(id));

    }

    @Override
    public void updCmsTitle(CmsTitle cmsTitle) {
        cmsTitleMapper.updateById(cmsTitle);
    }

    @Override
    public List<CmsTitle> getCmsTitleAll() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("title_pid",0);
        List<CmsTitle> cmsTitleList = cmsTitleMapper.selectList(wrapper);
        for (CmsTitle cmsTitle : cmsTitleList) {
            QueryWrapper wrapper1=new QueryWrapper();
            wrapper1.eq("title_pid",cmsTitle.getId());
            List<CmsTitle> chilidList=cmsTitleMapper.selectList(wrapper1);
            cmsTitle.setChildList(chilidList);
        }
        return cmsTitleList;
    }
}
