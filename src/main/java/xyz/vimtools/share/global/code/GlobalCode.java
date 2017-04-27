package xyz.vimtools.share.global.code;

/**
 * 全局错误码
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-4-27
 */
public enum GlobalCode implements ErrorCode {

    SUCCESS(200, "请求成功!"),
    ERROR(300, "未知错误!"),
    NO_LOGIN(401, "请先登录后再操作!"),
    NO_AUTHORIZED(403, "请求的资源没有权限!"),
    SERVER_EXCEPTION(500, "服务器异常!"),
    ILLEGAL_OPERATE(900, "非法操作!"),
    PARAM_EXCEPTION(1000, "参数异常!"),
    EXIST_CASCADE(2000, "存在级联!")
    ;

    /**
     * 状态码
     */
    private final int code;

    /**
     * 描述信息
     */
    private final String message;

    GlobalCode(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
