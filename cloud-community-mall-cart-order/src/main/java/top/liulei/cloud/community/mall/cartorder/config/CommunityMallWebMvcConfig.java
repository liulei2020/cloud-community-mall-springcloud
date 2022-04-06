package top.liulei.cloud.community.mall.cartorder.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 描述：     地址映射配置
 */
@Configuration
public class CommunityMallWebMvcConfig implements WebMvcConfigurer {

    @Value("${file.upload.dir}")
    String FILE_UPLOAD_DIR;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:" + FILE_UPLOAD_DIR);
    }
}
