package xyz.vimtools.share.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-5-5
 */
public class EncryptUtils {

    /**
     * 传入文本内容，返回MD5串
     *
     * @param strText 加密源
     * @return MD5加密字符串（32位）
     */
    public static String MD5(String strText) {
        return SHA(strText, "MD5");
    }

    /**
     * 传入文本内容，返回SHA-256串
     *
     * @param strText 加密源
     * @return SHA-256加密字符串（64位）
     */
    public static String SHA256(String strText) {
        return SHA(strText, "SHA-256");
    }

    /**
     * 传入文本内容，返回SHA-512串
     *
     * @param strText 加密源
     * @return SHA-512加密字符串（128位）
     */
    public static String SHA512(String strText) {
        return SHA(strText, "SHA-512");
    }

    /**
     * 字符串SHA加密
     *
     * @param strText 加密源
     * @param strType 加密类型
     * @return 加密字符串
     */
    private static String SHA(String strText, String strType) {
        // 返回值
        String strResult = null;

        // 是否是有效字符串
        if (strText != null && strText.length() > 0) {
            try {
                // SHA加密开始
                // 创建加密对象 并传入加密类型
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                // 传入要加密的字符串
                messageDigest.update(strText.getBytes());
                // 得到byte类型结果
                byte byteBuffer[] = messageDigest.digest();

                // 将byte转换为string
                StringBuffer strHexString = new StringBuffer();
                // 遍历byte buffer
                for (int i = 0; i < byteBuffer.length; i++) {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                // 得到返回结果
                strResult = strHexString.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        return strResult;
    }
}
