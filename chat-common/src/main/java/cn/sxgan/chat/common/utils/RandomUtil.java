package cn.sxgan.chat.common.utils;

import java.security.SecureRandom;

/**
 * @Description: 随机工具
 * @Author: sxgan
 * @Date: 2024-08-01 15:56
 * @Version: 1.0
 **/

public class RandomUtil {
    private static final String CHAR_SET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final SecureRandom RANDOM = new SecureRandom();
    
    /**
     * 生成0-9，A-Z之间的随机字符串
     *
     * @param length 指定字符串长度
     * @return 返回生成字符串
     */
    public static String generateRandomCode(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }
        StringBuilder code = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            code.append(CHAR_SET.charAt(RANDOM.nextInt(CHAR_SET.length())));
        }
        return code.toString();
    }
}
