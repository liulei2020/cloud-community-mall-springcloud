package top.liulei.cloud.community.mall.user.service;


import top.liulei.cloud.community.mall.common.exception.CommunityMallException;
import top.liulei.cloud.community.mall.user.model.pojo.User;

/**
 * 描述：     UserService
 */
public interface UserService {

    void register(String userName, String password) throws CommunityMallException;

    User login(String userName, String password) throws CommunityMallException;

    void updateInformation(User user) throws CommunityMallException;

    boolean checkAdminRole(User user);
}
