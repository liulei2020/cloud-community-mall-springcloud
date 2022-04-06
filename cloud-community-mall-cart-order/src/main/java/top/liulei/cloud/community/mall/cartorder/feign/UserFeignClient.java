package top.liulei.cloud.community.mall.cartorder.feign;

import top.liulei.cloud.community.mall.user.model.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 描述：     UserFeign客户端
 */
@FeignClient(value = "cloud-community-mall-user")
public interface UserFeignClient {

    /**
     * 获取当前登录的User对象
     * @return
     */
    @GetMapping("/getUser")
    User getUser();
}
