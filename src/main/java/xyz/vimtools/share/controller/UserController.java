package xyz.vimtools.share.controller;

import org.springframework.web.bind.annotation.*;
import xyz.vimtools.share.domain.model.User;
import xyz.vimtools.share.global.code.GlobalCode;
import xyz.vimtools.share.global.code.UserCode;
import xyz.vimtools.share.global.helper.LoginHelper;
import xyz.vimtools.share.global.response.ResponseInfo;
import xyz.vimtools.share.service.UserService;
import xyz.vimtools.share.util.AssertUtils;
import xyz.vimtools.share.util.RegexUtils;

import javax.annotation.Resource;

/**
 * 用户控制层
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-4-25
 */

@RestController
@RequestMapping(path = "user")
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
    @ResponseBody
    public ResponseInfo createUser(@RequestBody User user) {

        AssertUtils.notNull(GlobalCode.PARAM_EXCEPTION, user);
        AssertUtils.isTrue(UserCode.EMAIL_FORMAT_ERROR, RegexUtils.isEmail(user.getEmail()));

        userService.addUser(user);
        return ResponseInfo.buildErrorResponseInfo();
    }

    @RequestMapping(path = "login", method = RequestMethod.GET)
    @ResponseBody
    public ResponseInfo login(@RequestParam String email, @RequestParam String password) {

        AssertUtils.notNull(GlobalCode.PARAM_EXCEPTION, email, password);
        AssertUtils.isTrue(UserCode.EMAIL_FORMAT_ERROR, RegexUtils.isEmail(email));
        User user = userService.findByEmail(email);
        AssertUtils.notNull(GlobalCode.PARAM_EXCEPTION, user);

        if (password.equals(user.getPassword())) {
            setCurrentUser(user.getId());
            ResponseInfo responseInfo = ResponseInfo.buildSuccessResponseInfo();
            responseInfo.putData("user", user);
            return responseInfo;
        }

        return ResponseInfo.buildErrorResponseInfo();
    }

    @RequestMapping(path = "test", method = RequestMethod.GET)
    @ResponseBody
    public ResponseInfo test() {
        User currentUser = getCurrentUser();
        ResponseInfo responseInfo = ResponseInfo.buildSuccessResponseInfo();
        responseInfo.putData("user", currentUser);
        return responseInfo;
    }
}
