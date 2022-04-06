package top.liulei.cloud.community.mall.user.model.dao;



import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.liulei.cloud.community.mall.user.model.pojo.User;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByName(String userName);

    User selectLogin(@Param("userName") String userName, @Param("password") String password);
}