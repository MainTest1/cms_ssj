//package com.ssj;
//
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.ssj.cms.entity.CmsTitle;
//import com.ssj.cms.service.CmsTitleService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MybatisTest {
//    @Resource
//    CmsTitleService cmsTitleService;
//
//    @Test
//    public void selectAll() {
//        QueryWrapper<CmsTitle> wrapper = new QueryWrapper<>();
//        List<CmsTitle> cmsTitleList = cmsTitleService.list(wrapper);
//        for (CmsTitle cmsTitle : cmsTitleList) {
//            System.out.println(cmsTitle);
//        }
//    }
//}
