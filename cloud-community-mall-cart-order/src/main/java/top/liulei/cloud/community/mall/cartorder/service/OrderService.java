package top.liulei.cloud.community.mall.cartorder.service;

import com.github.pagehelper.PageInfo;
import top.liulei.cloud.community.mall.cartorder.model.request.CreateOrderReq;
import top.liulei.cloud.community.mall.cartorder.model.vo.OrderVO;


/**
 * 描述：     订单Service
 */
public interface OrderService {


    String create(CreateOrderReq createOrderReq);

    OrderVO detail(String orderNo);

    PageInfo listForCustomer(Integer pageNum, Integer pageSize);

    void cancel(String orderNo);

    String qrcode(String orderNo);

    void pay(String orderNo);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);

    void deliver(String orderNo);

    void finish(String orderNo);
}
