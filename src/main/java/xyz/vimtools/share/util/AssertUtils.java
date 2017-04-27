package xyz.vimtools.share.util;

import xyz.vimtools.share.global.code.ErrorCode;
import xyz.vimtools.share.global.exception.ExceptionUtils;
import xyz.vimtools.share.global.exception.ResponseException;

import java.util.Collection;
import java.util.Map;

/**
 * 断言判断工具类
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-4-27
 */
public class AssertUtils {

    private static final AssertUtils INSTANCE = new AssertUtils();

    private AssertUtils() {}

    /**
     * Assert args is null, if not null throw new {@link ResponseException}
     * use errorCode {@link ErrorCode}
     *
     * @param errorCode response info
     * @param args need Assert args value
     */
    public static void isNull(ErrorCode errorCode, Object ... args) {
        if (null == args) {
            return;
        }
        for (Object arg : args) {
            if (null != arg) {
                if (arg instanceof String && !StringUtils.isNotBlank(arg.toString())) {
                    ExceptionUtils.throwResponseException(errorCode);
                }
                if (arg instanceof Collection && ((Collection<?>) arg).size() > 0) {
                    ExceptionUtils.throwResponseException(errorCode);
                }
                if (arg instanceof Map && ((Map<?, ?>) arg).size() > 0) {
                    ExceptionUtils.throwResponseException(errorCode);
                }
                ExceptionUtils.throwResponseException(errorCode);
            }
        }
    }

    /**
     * Assert args is not null,if null throw new {@link ResponseException}
     * use errorCode {@link ErrorCode}
     *
     * @param errorCode response info
     * @param args need Assert args value
     */
    public static void notNull(ErrorCode errorCode, Object ... args) {
        if (null == args) {
            ExceptionUtils.throwResponseException(errorCode);
        }
        for(Object arg : args){
            if (null == arg) {
                ExceptionUtils.throwResponseException(errorCode);
            }
            if (arg instanceof String && StringUtils.isBlank(arg.toString())) {
                ExceptionUtils.throwResponseException(errorCode);
            }
            if (arg instanceof Collection && ((Collection<?>) arg).size() == 0) {
                ExceptionUtils.throwResponseException(errorCode);
            }
            if (arg instanceof Map && ((Map<?,?>) arg).size() == 0) {
                ExceptionUtils.throwResponseException(errorCode);
            }
        }
    }

    /**
     * Assert a boolean expression, throwing {@link ResponseException}
     * if the test context is {@code false}.
     * <pre class="code">Assert.isTrue(i &gt; 0, "The value must be greater than zero");</pre>
     *
     * @param errorCode response info
     * @param expression need Assert boolean expression
     */
    public static void isTrue(ErrorCode errorCode, boolean expression) {
        if (!expression) {
            ExceptionUtils.throwResponseException(errorCode);
        }
    }

    /**
     * Assert text must be match the patter
     * if the match the patter context false.
     * throw new {@link ResponseException}
     *
     * @param errorCode response info
     * @param text Assert text
     */
    public static void isNumber(ErrorCode errorCode, String text) {
        if(StringUtils.isBlank(text))
            ExceptionUtils.throwResponseException(errorCode);
        if(!RegexUtils.isNumber(text))
            ExceptionUtils.throwResponseException(errorCode);
    }

    /**
     * Assert mobile must be match the patter
     * if the match the patter context false.
     * throw new {@link ResponseException}
     *
     * @param errorCode response info
     * @param text Assert text
     */
    public static void isMobile(ErrorCode errorCode, String text) {
        if(StringUtils.isBlank(text))
            ExceptionUtils.throwResponseException(errorCode);
        if(!RegexUtils.isMobileNumber(text))
            ExceptionUtils.throwResponseException(errorCode);
    }

    /**
     * Assert id card must be match the patter
     * if the match the patter context false.
     * throw new {@link ResponseException}
     *
     * @param errorCode response info
     * @param text Assert text
     */
    public static void isIdCard(ErrorCode errorCode, String text) {
        if(StringUtils.isBlank(text))
            ExceptionUtils.throwResponseException(errorCode);
        if(!RegexUtils.isIdCard(text))
            ExceptionUtils.throwResponseException(errorCode);

    }

    /**
     * Assert tel phone must be match the patter
     * if the match the patter context false.
     * throw new {@link ResponseException}
     *
     * @param errorCode response info
     * @param text Assert text
     */
    public static void isTelPhone(ErrorCode errorCode, String text) {
        if(StringUtils.isBlank(text))
            ExceptionUtils.throwResponseException(errorCode);
        if(!RegexUtils.isTelPhone(text))
            ExceptionUtils.throwResponseException(errorCode);
    }

    /**
     * Assert zip code must be match the patter
     * if the match the patter context false.
     * throw new {@link ResponseException}
     *
     * @param errorCode response info
     * @param text Assert text
     */
    public static void isZipCode(ErrorCode errorCode, String text) {
        if(StringUtils.isBlank(text))
            ExceptionUtils.throwResponseException(errorCode);
        if(!RegexUtils.isZipCode(text))
            ExceptionUtils.throwResponseException(errorCode);
    }

    /**
     * Assert Chinese characters must be match the patter
     * if the match the patter context false.
     * throw new {@link ResponseException}
     *
     * @param errorCode response info
     * @param text Assert text
     */
    public static void isChinese(ErrorCode errorCode, String text) {
        if(StringUtils.isBlank(text))
            ExceptionUtils.throwResponseException(errorCode);
        if(!RegexUtils.isChinese(text))
            ExceptionUtils.throwResponseException(errorCode);
    }

    /**
     * Assert email must be match the patter
     * if the match the patter context false.
     * throw new {@link ResponseException}
     *
     * @param errorCode response info
     * @param text Assert text
     */
    public static void isEmail(ErrorCode errorCode, String text) {
        if(StringUtils.isBlank(text))
            ExceptionUtils.throwResponseException(errorCode);
        if(!RegexUtils.isEmail(text))
            ExceptionUtils.throwResponseException(errorCode);
    }

    /**
     * Assert object must be in the objects
     * throw new {@link ResponseException}
     *
     * @param errorCode response info
     * @param object Assert object
     * @param objects Assert objects
     */
    public static void isInclude(ErrorCode errorCode, Object object, Object ... objects) {
        if (null == objects || null == object) {
            ExceptionUtils.throwResponseException(errorCode);
        }

        boolean in = false;
        for(Object o : objects){
            if (null == o) {
                ExceptionUtils.throwResponseException(errorCode);
            }

            if (object.equals(o)) {
                in = true;
                break;
            }
        }

        if (!in) {
            ExceptionUtils.throwResponseException(errorCode);
        }
    }
}
