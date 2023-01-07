package com.ssj.cms.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssj.cms.entity.SysUser;
import com.ssj.cms.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class SysUserController {
    @Resource
    HttpSession session;
    @Resource
    SysUserService sysUserService;

    @RequestMapping("sysuserList")
    public String sysuserList() {
        return "admin/sysusermgr";
    }

    @RequestMapping("sysUserListPage")
    @ResponseBody
    public DataTableJSONResponse sysUserListPage(@RequestParam Map<String, String> param) {
        String sEcho = param.get("sEcho");
        int sEchoInt = Integer.valueOf(sEcho);
        String start = param.get("iDisplayStart");
        String pageSzie = param.get("iDisplayLength");
        int current = (Integer.valueOf(start) / Integer.valueOf(pageSzie))+1;//当前页码
        IPage<SysUser> sysUserIPage =
                sysUserService.getSysUserByPage(current);
        List<SysUser> sysRoleList = sysUserIPage.getRecords();
        DataTableJSONResponse dataTableJSONResponse = new DataTableJSONResponse(sysRoleList);
        dataTableJSONResponse.setDraw(sEchoInt);
        dataTableJSONResponse.setRecordsFiltered(sysUserIPage.getTotal());
        dataTableJSONResponse.setRecordsFiltered(sysUserIPage.getTotal());
        return dataTableJSONResponse;
    }

    @RequestMapping("addSysUser")
    public String addSysUser(SysUser sysUser) {
        sysUserService.addSysUser(sysUser);
        return "redirect:sysuserList";
    }

    @RequestMapping("delSysUser")
    public String delSysUser(String id) {
        sysUserService.delSysUser(id);
        return "redirect:sysuserList";
    }

    @RequestMapping("getsysuserbyid")
    @ResponseBody
    public SysUser getsysuserbyid(String id) {
        //ajax
        SysUser sysUser = sysUserService.getSysUserById(id);
        return sysUser;
    }

    @RequestMapping("updSysUser")
    public String updSysUser(SysUser sysUser) {
        sysUserService.updSysUser(sysUser);
        return "redirect:sysuserList";
    }
}
