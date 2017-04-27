package xyz.vimtools.share.global.response;

import xyz.vimtools.share.global.code.ErrorCode;
import xyz.vimtools.share.global.code.GlobalCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据封装类
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-4-27
 */
public class ResponseInfo {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误码描述
     */
    private String msg;

    /**
     * 返回数据
     */
    private Map<String, Object> data = new HashMap<>();

    public ResponseInfo(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
    }

    public ResponseInfo(ErrorCode errorCode, String msg) {
        this.code = errorCode.getCode();
        this.msg = msg;
    }

    public static ResponseInfo buildSuccessResponseInfo() {
        return new ResponseInfo(GlobalCode.SUCCESS);
    }

    public static ResponseInfo buildErrorResponseInfo() {
        return new ResponseInfo(GlobalCode.ERROR);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public void putData(String key, Object value){
        this.data.put(key, value);
    }

    @Override
    public String toString() {
        return "ResponseInfo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
