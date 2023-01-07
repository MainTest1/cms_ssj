package com.ssj.cms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssj.cms.entity.CmsBanner;

public interface CmsBannerService {
    IPage<CmsBanner> getCmsBannerByPage(int current,int size);

    void addCmsBanner(CmsBanner cmsBanner);

    void delCmsBanner(String id);

    CmsBanner getCmsBannerById(String id);

    void updCmsBanner(CmsBanner cmsBanner);

}
