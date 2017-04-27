package xyz.vimtools.share.global.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.vimtools.share.global.response.ResponseInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-4-27
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理ResponseException异常类
     *
     * @param request 请求
     * @param exception 异常
     * @return 异常返回信息
     * @throws Exception 异常
     */
    @ExceptionHandler(value = ResponseException.class)
    @ResponseBody
    public Object responseExceptionHandler(HttpServletRequest request, ResponseException exception) throws Exception {
        return new ResponseInfo(exception.getErrorCode());
    }
}
