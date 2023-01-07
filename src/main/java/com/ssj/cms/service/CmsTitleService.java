package com.ssj.cms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssj.cms.entity.CmsTitle;
import com.ssj.cms.entity.SysRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CmsTitleService  {
    IPage<CmsTitle> getCmsTitleByPage(int current);

    void addCmsTitle(CmsTitle cmsTitle);

    void delCmsTitle(String id);

    CmsTitle getCmsTitleById(String id);

    void updCmsTitle(CmsTitle cmsTitle);

    List<CmsTitle> getCmsTitleAll();
}
