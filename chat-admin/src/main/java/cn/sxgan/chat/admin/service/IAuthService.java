package cn.sxgan.chat.admin.service;

import cn.sxgan.chat.common.entity.UserInfo;
import cn.sxgan.chat.common.response.Result;

import java.util.Map;

/**
 * @Description: 认证服务接口
 * @Author: sxgan
 * @Date: 2024-08-02 16:30
 * @Version: 1.0
 **/

public interface IAuthService {
    /**
     * 通过邮箱验证用户
     *
     * @param userInfo 当前登录用户
     * @return 存在返回用户
     */
    Result<Map<String, String>> userAuthByEmail(UserInfo userInfo);
    
    /**
     * 通过邮箱注册用户
     *
     * @param userInfo 当前登录用户
     * @return 提示消息
     */
    Result<Map<String, String>> signupUserByEmail(UserInfo userInfo);
}
