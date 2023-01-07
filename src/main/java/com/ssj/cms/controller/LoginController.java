package com.ssj.cms.controller;

import com.ssj.cms.entity.SysUser;
import com.ssj.cms.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class LoginController {
    @Resource
    SysUserService sysUserService;

    @RequestMapping("login.html")
    public String loginHtml() {
        return "login";
    }


    @RequestMapping("adminlogin")
    public String adminLogin(String userName, String userPwd) {
        System.out.println(userName);
        System.out.println(userPwd);
        SysUser sysUser = sysUserService.getSysUserByUserCode(userName);
        if (sysUser != null) {
            if (userPwd.equals(sysUser.getUserPwd())) {
                return "admin/frame";
            }
        }
        return "redirect:login.html";
    }
}
