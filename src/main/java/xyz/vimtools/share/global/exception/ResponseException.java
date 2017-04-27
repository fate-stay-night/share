package xyz.vimtools.share.global.exception;

import xyz.vimtools.share.global.code.ErrorCode;

/**
 * 返回值统一异常
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-4-27
 */
public class ResponseException extends RuntimeException {

    private ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public ResponseException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ResponseException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
