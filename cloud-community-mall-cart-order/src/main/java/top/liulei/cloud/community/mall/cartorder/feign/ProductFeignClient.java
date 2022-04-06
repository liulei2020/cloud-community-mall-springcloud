package top.liulei.cloud.community.mall.cartorder.feign;

import top.liulei.cloud.community.mall.productcategory.model.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述：     商品FeignClient
 */
@FeignClient(value = "cloud-community-mall-product-category")
public interface ProductFeignClient {

    @GetMapping("product/detailForFeign")
    Product detailForFeign(@RequestParam Integer id);

    @PostMapping("product/updateStock")
    void updateStock(@RequestParam Integer productId, @RequestParam Integer stock);

}
