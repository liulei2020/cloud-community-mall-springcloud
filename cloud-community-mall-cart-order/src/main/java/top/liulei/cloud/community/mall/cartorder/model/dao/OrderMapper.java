package top.liulei.cloud.community.mall.cartorder.model.dao;


import java.util.List;
import org.springframework.stereotype.Repository;
import top.liulei.cloud.community.mall.cartorder.model.pojo.Order;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Order selectByOrderNo(String orderNo);

    List<Order> selectForCustomer(Integer userId);

    List<Order> selectAllForAdmin();
}