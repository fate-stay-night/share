package xyz.vimtools.share.global.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import xyz.vimtools.share.global.code.GlobalCode;
import xyz.vimtools.share.global.exception.ExceptionUtils;
import xyz.vimtools.share.global.helper.LoginHelper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录认证拦截器
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-4-28
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private LoginHelper loginHelper;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if (!loginHelper.isLoginUser()) {
            ExceptionUtils.throwResponseException(GlobalCode.NO_LOGIN);
        }
        return true;
    }
}
