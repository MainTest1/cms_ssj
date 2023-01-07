package com.ssj.cms.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


@Configuration
public class MybatisPlusConfig {

    @Autowired
    DataSource dataSource;

    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory mainSqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 需要在这里指定xml文件的位置，不然自定义的sql会报Invalid bound statement异常
        bean.setMapperLocations(resolver.getResources("classpath*:mapper/*Mapper.xml"));

        //手动设置session工厂时，需要手动添加分页插件
        Interceptor[] plugins = new Interceptor[1];
        plugins[0] = paginationInterceptor();
        bean.setPlugins(plugins);
        return bean.getObject();
    }
}