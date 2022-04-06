package top.liulei.cloud.community.mall.cartorder.model.dao;


import java.util.List;
import org.springframework.stereotype.Repository;
import top.liulei.cloud.community.mall.cartorder.model.pojo.OrderItem;

@Repository
public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    List<OrderItem> selectByOrderNo(String orderNo);
}