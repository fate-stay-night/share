package xyz.vimtools.share.global.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import xyz.vimtools.share.domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户登录帮助类
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-5-4
 */
@Component
public class LoginHelper {

//    /** session有效期，默认1800s */
//    private static final Integer DEFAULT_MAX_INTERVAL = 1800;

    public static final String CURRENT_USER = "user";

    /**
     * 保存当前用户到session
     */
    public void setCurrentUser(User user){
        HttpSession httpSession = getSession();
//        httpSession.setMaxInactiveInterval(DEFAULT_MAX_INTERVAL);
        httpSession.setAttribute(CURRENT_USER, user);
    }

    /**
     * 从session中获取当前用户信息
     */
    public User getCurrentUser() {
        return  (User) getSession().getAttribute(CURRENT_USER);
    }

    public HttpSession getSession() {
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request.getSession();
    }

    /**
     * 是否为登陆用户
     */
    public Boolean isLoginUser() {
        return getCurrentUser() != null;
    }
}
