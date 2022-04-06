package top.liulei.cloud.community.mall.productcategory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 描述：     ProductCategoryApplication
 */
@SpringBootApplication
@EnableRedisHttpSession
@EnableFeignClients
@MapperScan(basePackages = "top.liulei.cloud.community.mall.productcategory.model.dao")
public class ProductCategoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCategoryApplication.class, args);
    }
}
