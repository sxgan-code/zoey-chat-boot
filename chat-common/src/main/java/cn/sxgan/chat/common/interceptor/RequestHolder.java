package cn.sxgan.chat.common.interceptor;

import cn.sxgan.chat.common.entity.UserInfo;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @Description: 请求持有实体，用于存放每次请求
 * @Author: sxgan
 * @Date: 24/8/1 18:23
 * @Version: 1.0
 **/
public class RequestHolder {
    private static final ThreadLocal<UserInfo> userHolder = new ThreadLocal<UserInfo>();
    
    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();
    
    public static void add(UserInfo sysUser) {
        userHolder.set(sysUser);
    }
    
    public static void add(HttpServletRequest request) {
        requestHolder.set(request);
    }
    
    public static UserInfo getCurrentUser() {
        return userHolder.get();
    }
    
    public static HttpServletRequest getCurrentRequest() {
        return requestHolder.get();
    }
    
    public static void remove() {
        userHolder.remove();
        requestHolder.remove();
    }
}