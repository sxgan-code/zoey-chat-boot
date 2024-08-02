package cn.sxgan.chat.common.interceptor;

import cn.sxgan.chat.common.config.ZoeyConfig;
import cn.sxgan.chat.common.consts.RedisConst;
import cn.sxgan.chat.common.entity.UserInfo;
import cn.sxgan.chat.common.enums.ResStatusEnum;
import cn.sxgan.chat.common.response.Result;
import cn.sxgan.chat.common.utils.JsonUtil;
import cn.sxgan.chat.common.utils.RedisUtil;
import cn.sxgan.chat.common.utils.secret.JwtUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 认证拦截器
 * @Author: sxgan
 * @Date: 24/8/1 18:26
 * @Version: 1.0
 **/
@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
    
    @Resource
    RedisUtil redisUtil;
    
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        String adminToken = request.getHeader("AdminToken");
        if (ZoeyConfig.adminSecretKey.equals(adminToken)) {
            return true;
        }
        if (StringUtils.isBlank(token) || !JwtUtil.checkToken(token)) {
            returnLogin(response);
            return false;
        }
        // 拦截器在bean初始化前执行的，这时候redisUtil是null，需要通过下面这个方式去获取
        if (redisUtil == null) {
            WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            redisUtil = wac.getBean(RedisUtil.class);
        }
        // 鉴权Token
        UserInfo user = redisUtil.get(RedisConst.LOGIN_TOKEN_PREFIX + token, UserInfo.class);
        log.info("current user = {}", user);
        if (user == null) {
            log.info("user is blank");
            returnLogin(response);
            return false;
        }
        RequestHolder.add(user);
        // 重置登陆时间
        redisUtil.set(RedisConst.LOGIN_TOKEN_PREFIX + token, user, RedisConst.LOGIN_TIME_1, TimeUnit.DAYS);
        return true;
    }
    
    /**
     * 设置验证失败，跳转登陆
     *
     * @param response
     * @throws IOException
     */
    private void returnLogin(HttpServletResponse response) throws IOException {
        log.warn("The request is not login");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        response.setStatus(200); // 权限不足
        writer.write(JsonUtil.toJsonString(Result.fail(null,
                ResStatusEnum.EXCEPTION_STATUS_700.getCode(),
                ResStatusEnum.EXCEPTION_STATUS_700.getMsg())));
    }
}