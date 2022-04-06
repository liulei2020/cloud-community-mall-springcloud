package top.liulei.cloud.community.mall.user.controller;



import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import top.liulei.cloud.community.mall.common.common.ApiRestResponse;
import top.liulei.cloud.community.mall.common.common.Constant;
import top.liulei.cloud.community.mall.common.exception.CommunityMallException;
import top.liulei.cloud.community.mall.common.exception.CommunityMallExceptionEnum;
import top.liulei.cloud.community.mall.user.model.pojo.User;
import top.liulei.cloud.community.mall.user.service.UserService;

/**
 * 描述：     用户控制器
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 注册
     */
    @PostMapping("/register")
    @ResponseBody
    public ApiRestResponse register(@RequestParam("userName") String userName,
            @RequestParam("password") String password) throws CommunityMallException {
        if (StringUtils.isEmpty(userName)) {
            return ApiRestResponse.error(CommunityMallExceptionEnum.NEED_USER_NAME);
        }
        if (StringUtils.isEmpty(password)) {
            return ApiRestResponse.error(CommunityMallExceptionEnum.NEED_PASSWORD);
        }
        //密码长度不能少于8位
        if (password.length() < 8) {
            return ApiRestResponse.error(CommunityMallExceptionEnum.PASSWORD_TOO_SHORT);
        }
        userService.register(userName, password);
        return ApiRestResponse.success();
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    @ResponseBody
    public ApiRestResponse login(@RequestParam("userName") String userName,
            @RequestParam("password") String password, HttpSession session)
            throws CommunityMallException {
        if (StringUtils.isEmpty(userName)) {
            return ApiRestResponse.error(CommunityMallExceptionEnum.NEED_USER_NAME);
        }
        if (StringUtils.isEmpty(password)) {
            return ApiRestResponse.error(CommunityMallExceptionEnum.NEED_PASSWORD);
        }
        User user = userService.login(userName, password);
        //保存用户信息时，不保存密码
        user.setPassword(null);
        session.setAttribute(Constant.COMMUNITY_MALL_USER, user);
        return ApiRestResponse.success(user);
    }

    /**
     * 更新个性签名
     */
    @PostMapping("/user/update")
    @ResponseBody
    public ApiRestResponse updateUserInfo(HttpSession session, @RequestParam String signature)
            throws CommunityMallException {
        User currentUser = (User) session.getAttribute(Constant.COMMUNITY_MALL_USER);
        if (currentUser == null) {
            return ApiRestResponse.error(CommunityMallExceptionEnum.NEED_LOGIN);
        }
        User user = new User();
        user.setId(currentUser.getId());
        user.setPersonalizedSignature(signature);
        userService.updateInformation(user);
        return ApiRestResponse.success();
    }

    /**
     * 登出，清除session
     */
    @PostMapping("/user/logout")
    @ResponseBody
    public ApiRestResponse logout(HttpSession session) {
        session.removeAttribute(Constant.COMMUNITY_MALL_USER);
        return ApiRestResponse.success();
    }

    /**
     * 管理员登录接口
     */
    @PostMapping("/adminLogin")
    @ResponseBody
    public ApiRestResponse adminLogin(@RequestParam("userName") String userName,
            @RequestParam("password") String password, HttpSession session)
            throws CommunityMallException {
        if (StringUtils.isEmpty(userName)) {
            return ApiRestResponse.error(CommunityMallExceptionEnum.NEED_USER_NAME);
        }
        if (StringUtils.isEmpty(password)) {
            return ApiRestResponse.error(CommunityMallExceptionEnum.NEED_PASSWORD);
        }
        User user = userService.login(userName, password);
        //校验是否是管理员
        if (userService.checkAdminRole(user)) {
            //是管理员，执行操作
            //保存用户信息时，不保存密码
            user.setPassword(null);
            session.setAttribute(Constant.COMMUNITY_MALL_USER, user);
            return ApiRestResponse.success(user);
        } else {
            return ApiRestResponse.error(CommunityMallExceptionEnum.NEED_ADMIN);
        }
    }

    /**
     * 校验是否是管理员
     * @param user
     * @return
     */
    @PostMapping("/checkAdminRole")
    @ResponseBody
    public Boolean checkAdminRole(@RequestBody User user) {
        return userService.checkAdminRole(user);
    }


    /**
     * 获取当前登录的User对象
     * @param session
     * @return
     */
    @GetMapping("/getUser")
    @ResponseBody
    public User getUser(HttpSession session) {
        User currentUser = (User) session.getAttribute(Constant.COMMUNITY_MALL_USER);
        return currentUser;
    }
}
