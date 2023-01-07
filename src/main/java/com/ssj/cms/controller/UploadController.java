package com.ssj.cms.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {
    //图片上传
    //1.第三次jar comm
    //2.base64
    //3.第三方平台
    //4.spring mvc 原生文件上传
    @Value("${img.path}")
    private String path;

    @RequestMapping("/admin/upload")
    @ResponseBody//Spring mvc 文件上传
    public Map<String, String> upload(@RequestParam("file") MultipartFile file) {
        String newfileName = "";

        try {
            //获取上传文件的文件名称 比如文件名称logo.png
            String fileName = file.getOriginalFilename();
            //获取上传文件的后缀 .png
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            //重命名 获取系统当前时间 + 文件后缀
            newfileName = System.currentTimeMillis() + suffix;
            //拼接成新的文件路径
            String destFileName = path + File.separator + newfileName;
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            //上传文件
            file.transferTo(destFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Map<String, String> resMap = new HashMap<>();
        resMap.put("pathurl", "/img/" + newfileName);
        return resMap;
    }

}
