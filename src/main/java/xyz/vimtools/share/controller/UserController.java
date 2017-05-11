package xyz.vimtools.share.controller;

import org.springframework.web.bind.annotation.*;
import xyz.vimtools.share.domain.model.User;
import xyz.vimtools.share.global.code.GlobalCode;
import xyz.vimtools.share.global.code.UserCode;
import xyz.vimtools.share.global.helper.LoginHelper;
import xyz.vimtools.share.global.response.ResponseInfo;
import xyz.vimtools.share.service.UserService;
import xyz.vimtools.share.util.AssertUtils;
import xyz.vimtools.share.util.EncryptUtils;
import xyz.vimtools.share.util.RegexUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户控制层
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-4-25
 */

@RestController
@RequestMapping(path = "user")
@ResponseBody
public class UserController extends LoginHelper {

    @Resource
    private UserService userService;

    /**
     * 用户注册接口
     *
     * @param user 用户信息
     * @return 用户id
     */
    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseInfo createUser(@RequestBody User user) {

        AssertUtils.notNull(GlobalCode.PARAM_EXCEPTION, user);
        AssertUtils.isTrue(UserCode.EMAIL_FORMAT_ERROR, RegexUtils.isEmail(user.getEmail()));
        user.setPassword(EncryptUtils.SHA256(user.getPassword()));
        user.setCreateTime(new Date());
        String userId = userService.addUser(user);
        ResponseInfo responseInfo = ResponseInfo.buildSuccessResponseInfo();
        responseInfo.putData("id", userId);
        return responseInfo;
    }

    /**
     * 修改用户密码
     *
     * @param password 新的密码
     * @return 修改成功
     */
    @RequestMapping(path = "password", method = RequestMethod.PUT)
    public ResponseInfo changePassword(@RequestParam String password) {
        User user = getCurrentUser();
        user.setPassword(EncryptUtils.SHA256(password));
        user.setUpdateTime(new Date());
        userService.modifyUser(user);
        return ResponseInfo.buildSuccessResponseInfo();
    }

    /**
     * 修改用户昵称
     *
     * @param nickname 新的昵称
     * @return userDto 修改后的用户对象
     */
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseInfo editUser(@RequestParam String nickname) {
        User user = getCurrentUser();
        user.setNickname(nickname);
        user.setUpdateTime(new Date());
        userService.modifyUser(user);
        ResponseInfo responseInfo = ResponseInfo.buildSuccessResponseInfo();
        responseInfo.putData("user", userService.toDto(user));
        return responseInfo;
    }

    /**
     * 用户登录
     *
     * @param email    登录邮箱
     * @param password 登录密码
     * @return 用户信息
     */
    @RequestMapping(path = "login", method = RequestMethod.GET)
    public ResponseInfo login(@RequestParam String email, @RequestParam String password) {

        AssertUtils.notNull(GlobalCode.PARAM_EXCEPTION, email, password);
        AssertUtils.isTrue(UserCode.EMAIL_FORMAT_ERROR, RegexUtils.isEmail(email));
        User user = userService.findByEmail(email);
        AssertUtils.notNull(GlobalCode.PARAM_EXCEPTION, user);

        if (EncryptUtils.SHA256(password).equals(user.getPassword())) {
            setCurrentUser(user);
            ResponseInfo responseInfo = ResponseInfo.buildSuccessResponseInfo();
            responseInfo.putData("user", userService.toDto(user));
            return responseInfo;
        }

        return ResponseInfo.buildErrorResponseInfo();
    }

    /**
     * 用户登出
     */
    @RequestMapping(path = "logout", method = RequestMethod.GET)
    public ResponseInfo logout() {
        getSession().removeAttribute(CURRENT_USER);
        return ResponseInfo.buildSuccessResponseInfo();
    }

    @RequestMapping(path = "test", method = RequestMethod.GET)
    public ResponseInfo test() {
        User currentUser = getCurrentUser();
        ResponseInfo responseInfo = ResponseInfo.buildSuccessResponseInfo();
        responseInfo.putData("user", userService.toDto(currentUser));
        return responseInfo;
    }
}
