package com.handsure.handler;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author Arvin.Cao
 * @version 1.0
 * @time 16/3/23 下午12:31
 * @Description SpringMVC配置
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    /**
     * 添加JSON的序列化工具
     *
     * @return fastjson实例
     */
    @Bean
    public HttpMessageConverter jsonConverters() {
        SerializerFeature feature = SerializerFeature.DisableCircularReferenceDetect;
        HttpMessageConverter fastjson = new FastJsonHttpMessageConverter();

        return fastjson;
    }


    /**
     * 信息转换配置
     *
     * @param converters
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jsonConverters());

        super.configureMessageConverters(converters);
    }


//    @Override
//    protected void addViewControllers(ViewControllerRegistry registry) {
//        registry.addRedirectViewController("/", "/index.html");
//        super.addViewControllers(registry);
//    }

}
