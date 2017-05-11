package xyz.vimtools.share.util;

import xyz.vimtools.share.global.code.ErrorCode;
import xyz.vimtools.share.global.exception.ExceptionUtils;

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
     * 断言为null
     *
     * @param errorCode 错误码
     * @param args      断言参数
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
     * 断言不为null
     *
     * @param errorCode 错误码
     * @param args      断言参数
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
     * 断言为真
     *
     * @param errorCode  错误码
     * @param expression 断言条件
     */
    public static void isTrue(ErrorCode errorCode, boolean expression) {
        if (!expression) {
            ExceptionUtils.throwResponseException(errorCode);
        }
    }

    /**
     * 断言为数字
     *
     * @param errorCode 错误码
     * @param text      数字
     */
    public static void isNumber(ErrorCode errorCode, String text) {
        if(StringUtils.isBlank(text))
            ExceptionUtils.throwResponseException(errorCode);
        if(!RegexUtils.isNumber(text))
            ExceptionUtils.throwResponseException(errorCode);
    }

    /**
     * 断言为手机号
     *
     * @param errorCode 错误码
     * @param text      手机号
     */
    public static void isMobile(ErrorCode errorCode, String text) {
        if(StringUtils.isBlank(text))
            ExceptionUtils.throwResponseException(errorCode);
        if(!RegexUtils.isMobileNumber(text))
            ExceptionUtils.throwResponseException(errorCode);
    }

    /**
     * 断言为身份证号
     *
     * @param errorCode 错误码
     * @param text      身份证号
     */
    public static void isIdCard(ErrorCode errorCode, String text) {
        if(StringUtils.isBlank(text))
            ExceptionUtils.throwResponseException(errorCode);
        if(!RegexUtils.isIdCard(text))
            ExceptionUtils.throwResponseException(errorCode);

    }

    /**
     * 断言为电话号码
     *
     * @param errorCode 错误码
     * @param text      电话号码
     */
    public static void isTelPhone(ErrorCode errorCode, String text) {
        if(StringUtils.isBlank(text))
            ExceptionUtils.throwResponseException(errorCode);
        if(!RegexUtils.isTelPhone(text))
            ExceptionUtils.throwResponseException(errorCode);
    }

    /**
     * 断言为邮编
     *
     * @param errorCode 错误码
     * @param text      邮编
     */
    public static void isZipCode(ErrorCode errorCode, String text) {
        if(StringUtils.isBlank(text))
            ExceptionUtils.throwResponseException(errorCode);
        if(!RegexUtils.isZipCode(text))
            ExceptionUtils.throwResponseException(errorCode);
    }

    /**
     * 断言为汉字
     *
     * @param errorCode 错误码
     * @param text      汉字
     */
    public static void isChinese(ErrorCode errorCode, String text) {
        if(StringUtils.isBlank(text))
            ExceptionUtils.throwResponseException(errorCode);
        if(!RegexUtils.isChinese(text))
            ExceptionUtils.throwResponseException(errorCode);
    }

    /**
     * 断言为邮箱
     *
     * @param errorCode 错误码
     * @param text      email
     */
    public static void isEmail(ErrorCode errorCode, String text) {
        if(StringUtils.isBlank(text))
            ExceptionUtils.throwResponseException(errorCode);
        if(!RegexUtils.isEmail(text))
            ExceptionUtils.throwResponseException(errorCode);
    }

    /**
     * 断言对象在集合中
     *
     * @param errorCode 错误码
     * @param object    对象
     * @param objects   对象集合
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
