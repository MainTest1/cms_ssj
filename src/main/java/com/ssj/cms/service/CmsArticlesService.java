package com.ssj.cms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssj.cms.entity.CmsArticles;

public interface CmsArticlesService {
    IPage<CmsArticles> getCmsArticlesByPage(int current, int size);

    void addCmsArticles(CmsArticles cmsArticles);

    void delCmsArticles(String id);

    CmsArticles getCmsArticlesById(String id);

    void updCmsArticles(CmsArticles cmsArticles);
}
