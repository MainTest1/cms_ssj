package com.ssj.cms.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssj.cms.entity.SysRole;
import com.ssj.cms.service.SysRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class SysRoleController {
    @Resource
    HttpSession session;

    @Resource
    SysRoleService sysRoleService;

    @RequestMapping("sysroleList")
    public String sysroleList() {
        return "admin/sysrolemgr";
    }

    @RequestMapping("sysRoleListPage")
    @ResponseBody
    public DataTableJSONResponse sysRoleListPage(@RequestParam Map<String, String> param) {
        String sEcho = param.get("sEcho");
        int sEchoInt = Integer.valueOf(sEcho);
        String start = param.get("iDisplayStart");
        String pageSzie = param.get("iDisplayLength");
        int current = (Integer.valueOf(start) / Integer.valueOf(pageSzie))+1;//当前页码
        IPage<SysRole> sysRoleIPage =
                sysRoleService.getSysRoleByPage(current);
        List<SysRole> sysRoleList = sysRoleIPage.getRecords();
        DataTableJSONResponse dataTableJSONResponse = new DataTableJSONResponse(sysRoleList);
        dataTableJSONResponse.setDraw(sEchoInt);
        dataTableJSONResponse.setRecordsFiltered(sysRoleIPage.getTotal());
        return dataTableJSONResponse;
    }


    @RequestMapping("addSysRole")
    public String addSysRole(SysRole sysRole) {
        sysRoleService.addSysRole(sysRole);
        return "redirect:sysroleList";
    }

    @RequestMapping("delSysRole")
    public String delSysRole(String id) {
        sysRoleService.delSysRole(id);
        return "redirect:sysroleList";
    }

    @RequestMapping("getsysrolebyid")
    @ResponseBody
    public String getSysRoleById(String id) {
        //ajax
        SysRole sysRole = sysRoleService.getSysRoleById(id);
        String jsonStr = JSONObject.toJSONString(sysRole);
        return jsonStr;
    }

    @RequestMapping("updSysRole")
    public String updSysRole(SysRole sysRole) {
        sysRoleService.updSysRole(sysRole);
        return "redirect:sysroleList";
    }
}
