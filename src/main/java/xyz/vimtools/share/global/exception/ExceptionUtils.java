package xyz.vimtools.share.global.exception;

import org.springframework.util.CollectionUtils;
import xyz.vimtools.share.global.code.ErrorCode;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * 异常工具类
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-4-27
 */
public class ExceptionUtils {

    public static void throwResponseException(ErrorCode errorCode, String ... var) throws ResponseException {
        if (!CollectionUtils.isEmpty(Arrays.asList(var))) {
            String message = errorCode.getMessage();
            for (int i = 0; i < var.length; i++) {
                message = message.replace("{" + i + "}", var[i]);
            }
            throw new ResponseException(errorCode, message);
        } else {
            throw new ResponseException(errorCode);
        }
    }

    public static String getTrace(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        return buffer.toString();
    }
}
