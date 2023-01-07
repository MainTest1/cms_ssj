package com.ssj.cms.controller.home;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssj.cms.entity.CmsArticles;
import com.ssj.cms.entity.CmsBanner;
import com.ssj.cms.entity.CmsTitle;
import com.ssj.cms.service.CmsArticlesService;
import com.ssj.cms.service.CmsBannerService;
import com.ssj.cms.service.CmsTitleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    HttpSession session;

    @Resource
    CmsTitleService cmsTitleService;

    @Resource
    CmsBannerService bannerService;

    @Resource
    CmsArticlesService cmsArticlesService;

   @RequestMapping("/")
    public String index(){
       List<CmsTitle> cmsTitleList=cmsTitleService.getCmsTitleAll();
       session.setAttribute("cmsTitleList",cmsTitleList);
       IPage<CmsBanner> bannerIPage = bannerService.getCmsBannerByPage(1,10);
       session.setAttribute("cmsBannerList",bannerIPage.getRecords());
       IPage<CmsArticles> articlesIPage = cmsArticlesService.getCmsArticlesByPage(1, 10);
       session.setAttribute("cmsArticlesList", articlesIPage.getRecords());
       return "home/index";
   }

    @RequestMapping("singleDetail")
    public String singleDetail(String articlesId) {
        CmsArticles cmsArticles = cmsArticlesService.getCmsArticlesById(articlesId);
        cmsArticles.setArticleContentStr(new String(cmsArticles.getArticleContent()));
        session.setAttribute("cmsArticles",cmsArticles);
        return  "home/single";
    }

}
