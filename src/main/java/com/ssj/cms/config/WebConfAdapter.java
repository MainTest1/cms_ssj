package com.ssj.cms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * WEB MVC 配置
 *
 * @author wx
 */
@Configuration
public class WebConfAdapter implements WebMvcConfigurer  {
  @Value("${img.path}")
  private String path;

  private MyUserAuthenticationInterceptor securityInterceptor;

  @Autowired
  public WebConfAdapter(MyUserAuthenticationInterceptor securityInterceptor) {
    super();
    this.securityInterceptor = securityInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    //后台登录拦截器拦截路径
    registry.addInterceptor(securityInterceptor)
            .addPathPatterns("/admin/**")
            .excludePathPatterns("/admin/login");

  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    //主页
    //registry.addViewController("/").setViewName("forward:/admin/home");
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //配置静态资源路径
    registry.addResourceHandler("/**").addResourceLocations("classpath:static/");
    registry.addResourceHandler("/img/**/**").addResourceLocations("file:"+path);
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(responseBodyConverter());
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.favorPathExtension(false);
  }



  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowCredentials(true);
    configuration.addAllowedOrigin("*");
    configuration.addAllowedHeader("*");
    configuration.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE"));
    source.registerCorsConfiguration("/**", configuration);
    return new CorsFilter(source);
  }

  @Bean
  public HttpMessageConverter<String> responseBodyConverter() {
    //编码
    return new StringHttpMessageConverter(Charset.forName("UTF-8"));
  }

}
