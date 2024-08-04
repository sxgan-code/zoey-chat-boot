package cn.sxgan.chat.admin.controller.auth;

import cn.sxgan.chat.admin.api.auth.IAuthControllerApi;
import cn.sxgan.chat.admin.service.impl.AuthServiceImpl;
import cn.sxgan.chat.admin.service.impl.MailSendServiceImpl;
import cn.sxgan.chat.common.entity.UserInfo;
import cn.sxgan.chat.common.enums.ResStatusEnum;
import cn.sxgan.chat.common.response.Result;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description: 认证服务控制层
 * @Author: sxgan
 * @Date: 2024-08-02 15:55
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/auth")
public class AuthController implements IAuthControllerApi {
    
    @Resource
    MailSendServiceImpl mailSendService;
    
    @Resource
    AuthServiceImpl authService;
    
    @Override
    @PostMapping("/mailVerifyCode")
    public Result<String> sendEmailVerifyCode(@RequestBody UserInfo userInfo) {
        String email = userInfo.getEmail();
        if (StringUtils.isBlank(email)) {
            return Result.fail(ResStatusEnum.EXCEPTION_STATUS_900.getMsg());
        }
        String sendResult = mailSendService.sendVerifyCodeToSpecifiedEmail(email);
        if (StringUtils.isBlank(sendResult)) {
            return Result.success(sendResult);
        } else {
            return Result.fail(null, ResStatusEnum.EXCEPTION_STATUS_999.getCode(), sendResult);
        }
    }
    
    @Override
    @PostMapping("/signup")
    public Result<Map<String, String>> signup(@RequestBody UserInfo userInfo) {
        return authService.signupUserByEmail(userInfo);
    }
    
    @Override
    @GetMapping("/imgVerifyCode")
    public Result<Map<String, String>> getImgVerifyCode(HttpServletResponse response) {
        return authService.getImgVerifyCode(response);
    }
    
    @Override
    @PostMapping("/signin")
    public Result<Map<String, String>> signin(@RequestBody UserInfo userInfo) {
        return authService.userAuthByEmail(userInfo);
    }
}
