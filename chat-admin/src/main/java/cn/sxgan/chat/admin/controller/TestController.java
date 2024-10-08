package cn.sxgan.chat.admin.controller;

import cn.sxgan.chat.admin.api.ITestControllerApi;
import cn.sxgan.chat.common.entity.ChatUser;
import cn.sxgan.chat.common.entity.query.ChatUserQuery;
import cn.sxgan.chat.common.mappers.IChatUserMapper;
import cn.sxgan.chat.common.response.Result;
import cn.sxgan.chat.common.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 测试服务控制器
 * @Author: sxgan
 * @Date: 2024-08-01 13:26
 * @Version: 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController implements ITestControllerApi {
    
    @Autowired
    IChatUserMapper chatUserMapper;
    
    @GetMapping("/hello")
    public Result<String> hello(String var) {
        log.info("TestController.hello,param:{}", var);
        List<ChatUser> chatUsers = chatUserMapper.selectChatUserByCondition(new ChatUserQuery());
        return Result.success(JsonUtil.toJsonString(chatUsers));
    }
}
