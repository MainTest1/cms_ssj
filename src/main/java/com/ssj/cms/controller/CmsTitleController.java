package com.ssj.cms.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssj.cms.entity.CmsTitle;
import com.ssj.cms.service.CmsTitleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class CmsTitleController {
    @Resource
    HttpSession session;
    @Resource
    CmsTitleService cmsTitleService;

    @RequestMapping("cmstitleList")
    public String sysuserList() {
        return "admin/cmstitlemgr";
    }

    @RequestMapping("cmsTitleListPage")
    @ResponseBody
    public DataTableJSONResponse cmsTitleListPage(@RequestParam Map<String, String> param) {
        String sEcho = param.get("sEcho");
        int sEchoInt = Integer.valueOf(sEcho);
        String start = param.get("iDisplayStart");
        String pageSzie = param.get("iDisplayLength");
        int current = (Integer.valueOf(start) / Integer.valueOf(pageSzie))+1;//当前页码
        IPage<CmsTitle> cmsTitleByPage =
                cmsTitleService.getCmsTitleByPage(current);
        List<CmsTitle> cmsTitleList = cmsTitleByPage.getRecords();
        DataTableJSONResponse dataTableJSONResponse = new DataTableJSONResponse(cmsTitleList);
        dataTableJSONResponse.setDraw(sEchoInt);
        dataTableJSONResponse.setRecordsFiltered(cmsTitleByPage.getTotal());
//        dataTableJSONResponse.setRecordsFiltered(cmsTitleByPage.getTotal());
        return dataTableJSONResponse;
    }

    @RequestMapping("addCmsTitle")
    public String addCmsTitle(CmsTitle cmsTitle) {
        System.out.println(cmsTitle);
        cmsTitleService.addCmsTitle(cmsTitle);
        return "redirect:cmstitleList";
    }

    @RequestMapping("delCmsTitle")
    public String delCmsTitle(String id) {
        cmsTitleService.delCmsTitle(id);
        return "redirect:cmstitleList";
    }

    @RequestMapping("getCmsTitleById")
    @ResponseBody
    public CmsTitle getcmstitlebyid(String id) {
        //ajax
        CmsTitle cmsTitle = cmsTitleService.getCmsTitleById(id);
        return cmsTitle;
    }

    @RequestMapping("updCmsTitle")
    public String updCmsTitle(CmsTitle cmsTitle) {
        cmsTitleService.updCmsTitle(cmsTitle);
        return "redirect:cmstitleList";
    }

    @RequestMapping("getCmsTitleByPId")
    @ResponseBody
    public List<CmsTitle> getCmsTitleByPId() {
        List<CmsTitle> cmsTitleList =   cmsTitleService.getCmsTitleAll();
        return cmsTitleList;
    }

}
