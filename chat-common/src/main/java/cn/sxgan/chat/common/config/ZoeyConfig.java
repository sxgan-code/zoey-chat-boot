package cn.sxgan.chat.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description: 全局属性
 * @Author: sxgan
 * @Date: 24/8/1 18:15
 * @Version: 1.0
 **/
@Component
public class ZoeyConfig {
    
    public static String adminSecretKey;
    public static Integer emailKeyTime;
    public static String tokenKey;
    
    @Value("${zoey.auth.admin-secret-key}")
    public void setAdminSecretKey(String adminSecretKey) {
        ZoeyConfig.adminSecretKey = adminSecretKey;
    }
    
    @Value("${zoey.auth.email-key-time}")
    public void setEmailKeyTime(Integer emailKeyTime) {
        ZoeyConfig.emailKeyTime = emailKeyTime;
    }
    
    @Value("${zoey.auth.token-key}")
    public void setTokenKey(String tokenKey) {
        ZoeyConfig.tokenKey = tokenKey;
    }
}