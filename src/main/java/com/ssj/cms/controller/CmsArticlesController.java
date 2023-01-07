package com.ssj.cms.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssj.cms.entity.CmsArticles;
import com.ssj.cms.service.CmsArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class CmsArticlesController {
    @Autowired
    HttpSession session;
    @Autowired
    CmsArticlesService cmsArticlesService;

    @RequestMapping("cmsArticlesList")
    public String cmsArticlesList() {
        return "admin/cmsarticlesmgr";
    }

    @RequestMapping("cmsArticlesListPage")
    @ResponseBody
    public DataTableJSONResponse cmsArticlesListPage(@RequestParam Map<String, String> param) {
        String sEcho = param.get("sEcho");
        int sEchoInt = Integer.valueOf(sEcho);
        String start = param.get("iDisplayStart");
        String pageSzie = param.get("iDisplayLength");
        int current = (Integer.valueOf(start) / Integer.valueOf(pageSzie))+1;//当前页码
        IPage<CmsArticles> cmsArticlesIPage =
                cmsArticlesService.getCmsArticlesByPage(current,Integer.valueOf(pageSzie));
        List<CmsArticles> cmsArticlesList = cmsArticlesIPage.getRecords();
        DataTableJSONResponse dataTableJSONResponse = new DataTableJSONResponse(cmsArticlesList);
        dataTableJSONResponse.setDraw(sEchoInt);
        dataTableJSONResponse.setRecordsFiltered(cmsArticlesIPage.getTotal());
        dataTableJSONResponse.setRecordsFiltered(cmsArticlesIPage.getTotal());
        return dataTableJSONResponse;
    }

    @RequestMapping("addCmsArticles")
    public String addCmsArticles(CmsArticles cmsArticles) {
        byte[] bytes=cmsArticles.getArticleContentStr().getBytes();
        cmsArticles.setArticleContent(bytes);
        cmsArticles.setCreateDate(new Date());
        System.out.println(cmsArticles);
        cmsArticlesService.addCmsArticles(cmsArticles);
        return "redirect:cmsArticlesList";
    }

    @RequestMapping("delCmsArticles")
    public String delCmsArticles(String id) {
        cmsArticlesService.delCmsArticles(id);
        return "redirect:cmsArticlesList";
    }

    @RequestMapping("getCmsArticlesById")
    @ResponseBody
    public CmsArticles getCmsArticlesById(String id) {
        //ajax
        CmsArticles cmsArticles = cmsArticlesService.getCmsArticlesById(id);
        return cmsArticles;
    }

    @RequestMapping("updCmsArticles")
    public String updCmsArticles(CmsArticles cmsArticles) {
        cmsArticlesService.updCmsArticles(cmsArticles);
        return "redirect:cmsArticlesList";
    }
}
