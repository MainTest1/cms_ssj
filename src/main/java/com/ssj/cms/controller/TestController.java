package com.ssj.cms.controller;

import com.alibaba.fastjson.JSONObject;
import com.ssj.cms.entity.Datas;
import com.ssj.cms.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @RequestMapping("test1")
//    @ResponseBody
    public String test1() {
        String str = "{\"pageNum\":1,\"PageSize\":10,\"pageTotal\":100,\"pageCount\":10}";
        Object obj = JSONObject.toJSON(str);
        return obj.toString();
    }

    @RequestMapping("test2")
//    @ResponseBody
    public List<Student> test2() {
        Student student = new Student("张三", 1);
        Student student1 = new Student("李四", 20);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student1);
        return studentList;
    }

    @RequestMapping("test3")
    public Datas test3() {
        Student student = new Student("张三", 1);
        Student student1 = new Student("李四", 20);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student1);
        Datas datas = new Datas(1, 10, 100, 10, studentList);
        return datas;
    }

    @RequestMapping("test4")
    public Map<String,String> test4(@RequestBody Map<String,String> map){
        String name=map.get("name");
        System.out.println(name);
        return map;
    }

    @RequestMapping("test5")
    public String test5(@RequestHeader String token){
        return token;
    }
}
