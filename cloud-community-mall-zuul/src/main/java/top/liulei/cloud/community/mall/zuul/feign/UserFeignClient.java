package top.liulei.cloud.community.mall.zuul.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import top.liulei.cloud.community.mall.user.model.pojo.User;

/**
 * 描述：     UserFeignClient
 */
@FeignClient(value = "cloud-community-mall-user")
public interface UserFeignClient {

    @PostMapping("/checkAdminRole")
    public Boolean checkAdminRole(@RequestBody User user);
}
