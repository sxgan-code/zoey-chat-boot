package cn.sxgan.chat.common.consts;

/**
 * @Description: Redis常量
 * @Author: sxgan
 * @Date: 24/8/1 16:43
 * @Version: 1.0
 **/
public class RedisConst {
    /*Auth 认证相关 */
    public static String LOGIN_TOKEN_PREFIX = "login_token_";
    public static String CARD_CAPTCHA_PREFIX = "email_captcha_";
    public static String IMG_CAPTCHA_PREFIX = "img_captcha_";
    
    /*number*/
    public static Long LOGIN_TIME_1 = 1L;
    public static Long LOGIN_TIME_5 = 5L;
    public static Long LOGIN_TIME_30 = 30L;
    public static Long LOGIN_TIME_60 = 60L;
    
}