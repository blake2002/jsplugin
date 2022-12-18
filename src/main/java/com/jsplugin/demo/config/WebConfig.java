package com.jsplugin.demo.config;

import com.jsplugin.demo.interceptors.PluginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 添加Web项目的拦截器
     * 在指定拦截器拦截规则时，调用了两个方法，这两个方法的说明如下：
     * addPathPatterns：该方法用于指定拦截路径，例如拦截路径为 “/**”，表示拦截所有请求，包括对静态资源的请求。
     * excludePathPatterns：该方法用于排除拦截路径，即指定不需要被拦截器拦截的请求
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 对所有访问路径，都通过MyInterceptor类型的拦截器进行拦截
        registry.addInterceptor(new PluginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/", "/login", "/index.html", "/user/login", "/css/**", "/images/**", "/js/**", "/fonts/**");
        //放行登录页，登陆操作，静态资源
    }
}
