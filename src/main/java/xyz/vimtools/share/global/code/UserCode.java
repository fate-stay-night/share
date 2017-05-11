package xyz.vimtools.share.global.code;

/**
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-4-27
 */
public enum UserCode implements ErrorCode {

    HAVE_EXIST(10001, "邮箱已存在"),
    EMAIL_FORMAT_ERROR(10002, "邮箱格式不正确"),;

    /**
     * 状态码
     */
    private final int code;

    /**
     * 描述信息
     */
    private final String message;

    UserCode(int code, String msg) {
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
