package com.ssj.cms.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssj.cms.entity.CmsBanner;
import com.ssj.cms.service.CmsBannerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class CmsBannerController {
    @Resource
    HttpSession session;

    @Resource
    CmsBannerService cmsBannerService;

    @RequestMapping("cmsBannerList")
    public String cmsBannerList() {
        return "admin/cmsbannermgr";
    }

    @RequestMapping("cmsBannerListPage")
    @ResponseBody
    public DataTableJSONResponse cmsBannerListPage(@RequestParam Map<String, String> param) {
        String sEcho = param.get("sEcho");
        int sEchoInt = Integer.valueOf(sEcho);
        String start = param.get("iDisplayStart");
        String pageSzie = param.get("iDisplayLength");
        int current = (Integer.valueOf(start) / Integer.valueOf(pageSzie))+1;//当前页码
        IPage<CmsBanner> cmsBannerByPage =
                cmsBannerService.getCmsBannerByPage(current,Integer.parseInt(pageSzie));
        List<CmsBanner> cmsBannerList = cmsBannerByPage.getRecords();
        DataTableJSONResponse dataTableJSONResponse = new DataTableJSONResponse(cmsBannerList);
        dataTableJSONResponse.setDraw(sEchoInt);
        dataTableJSONResponse.setRecordsFiltered(cmsBannerByPage.getTotal());
        dataTableJSONResponse.setRecordsFiltered(cmsBannerByPage.getTotal());
        return dataTableJSONResponse;
    }


    @RequestMapping("addCmsBanner")
    public String addCmsBanner(CmsBanner cmsBanner) {
        cmsBanner.setCreateDate(new Date());
        cmsBannerService.addCmsBanner(cmsBanner);
        return "redirect:cmsBannerList";
    }

    @RequestMapping("delCmsBanner")
    public String delCmsBanner(String id) {
        cmsBannerService.delCmsBanner(id);
        return "redirect:cmsBannerList";
    }

    @RequestMapping("getCmsBannerById")
    @ResponseBody
    public CmsBanner getCmsBannerById(String id) {
        //ajax
        CmsBanner cmsBanner = cmsBannerService.getCmsBannerById(id);
//        String jsonStr = JSONObject.toJSONString(cmsBanner);
        return cmsBanner;
    }

    @RequestMapping("updCmsBanner")
    public String updCmsBanner(CmsBanner cmsBanner) {
        cmsBannerService.updCmsBanner(cmsBanner);
        return "redirect:cmsBannerList";
    }

}
