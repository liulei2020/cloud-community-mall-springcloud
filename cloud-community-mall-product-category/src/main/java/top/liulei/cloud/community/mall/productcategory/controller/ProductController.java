package top.liulei.cloud.community.mall.productcategory.controller;

import com.github.pagehelper.PageInfo;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.liulei.cloud.community.mall.common.common.ApiRestResponse;
import top.liulei.cloud.community.mall.productcategory.model.pojo.Product;
import top.liulei.cloud.community.mall.productcategory.model.request.ProductListReq;
import top.liulei.cloud.community.mall.productcategory.service.ProductService;

/**
 * 描述：     前台商品Controller
 */
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @ApiOperation("商品详情")
    @GetMapping("product/detail")
    public ApiRestResponse detail(@RequestParam Integer id) {
        Product product = productService.detail(id);
        return ApiRestResponse.success(product);
    }

    @ApiOperation("商品列表")
    @GetMapping("product/list")
    public ApiRestResponse list(ProductListReq productListReq) {
        PageInfo list = productService.list(productListReq);
        return ApiRestResponse.success(list);
    }

    @GetMapping("product/detailForFeign")
    public Product detailForFeign(@RequestParam Integer id) {
        Product product = productService.detail(id);
        return product;
    }

    @PostMapping("product/updateStock")
    public void updateStock(@RequestParam Integer productId, @RequestParam Integer stock) {
        productService.updateStock(productId, stock);
    }
}
