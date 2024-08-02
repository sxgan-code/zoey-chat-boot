package cn.sxgan.chat.admin.service.impl;

import cn.sxgan.chat.admin.service.IAuthService;
import cn.sxgan.chat.common.config.ZoeyConfig;
import cn.sxgan.chat.common.consts.RedisConst;
import cn.sxgan.chat.common.entity.ChatUser;
import cn.sxgan.chat.common.entity.UserInfo;
import cn.sxgan.chat.common.entity.query.ChatUserQuery;
import cn.sxgan.chat.common.enums.ResStatusEnum;
import cn.sxgan.chat.common.exception.AuthorityException;
import cn.sxgan.chat.common.mappers.IChatUserMapper;
import cn.sxgan.chat.common.response.Result;
import cn.sxgan.chat.common.utils.RandomUtil;
import cn.sxgan.chat.common.utils.RedisUtil;
import cn.sxgan.chat.common.utils.VerifyCodeUtil;
import cn.sxgan.chat.common.utils.secret.PwdUtil;
import com.google.common.collect.Maps;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 认证服务实现类
 * @Author: sxgan
 * @Date: 2024-08-02 16:29
 * @Version: 1.0
 **/
@Slf4j
@Service
public class AuthServiceImpl implements IAuthService {
    
    @Resource
    RedisUtil redisUtil;
    
    @Resource
    IChatUserMapper chatUserMapper;
    
    private static final String SYS_NAME_PREFIX = "chat_";
    
    @Override
    public Result<Map<String, String>> userAuthByEmail(UserInfo userInfo) {
        return null;
    }
    
    @Override
    public Result<Map<String, String>> signupUserByEmail(UserInfo userInfo) {
        String email = userInfo.getEmail();
        String password = userInfo.getPassword();
        String verifyCode = userInfo.getVerifyCode();
        if (StringUtils.isBlank(email) || StringUtils.isBlank(password) || StringUtils.isBlank(verifyCode)) {
            return Result.fail(Maps.newHashMap(), ResStatusEnum.EXCEPTION_STATUS_704.getCode(),
                    ResStatusEnum.EXCEPTION_STATUS_704.getMsg());
        }
        
        // 查询当前邮箱的验证码并验证
        String captchaCacheVal = redisUtil.get(RedisConst.CARD_CAPTCHA_PREFIX + email, String.class);
        log.info("AuthServiceImpl.signupUserByEmail emailCaptchaCacheVal = {}", captchaCacheVal);
        String[] captchaCacheValArr = null;
        if (captchaCacheVal != null) {
            captchaCacheValArr = captchaCacheVal.split("_");
            if (!captchaCacheValArr[0].equals(verifyCode)) {
                return Result.fail(Maps.newHashMap(), ResStatusEnum.EXCEPTION_STATUS_705.getCode(),
                        ResStatusEnum.EXCEPTION_STATUS_705.getMsg());
            }
        } else {
            return Result.fail(Maps.newHashMap(), ResStatusEnum.EXCEPTION_STATUS_705.getCode(),
                    ResStatusEnum.EXCEPTION_STATUS_705.getMsg());
        }
        long sendTime = Long.parseLong(captchaCacheValArr[2]);
        long currentTime = System.currentTimeMillis();
        if (currentTime - sendTime > ZoeyConfig.emailKeyTime * 1000) {
            return Result.fail(Maps.newHashMap(), ResStatusEnum.EXCEPTION_STATUS_709.getMsg());
        }
        // 查询邮箱是否已经注册
        ChatUserQuery userQuery = new ChatUserQuery();
        userQuery.setEmail(email);
        List<ChatUser> userList = chatUserMapper.selectChatUserByCondition(userQuery);
        if (!userList.isEmpty()) {
            return Result.fail(Maps.newHashMap(), ResStatusEnum.EXCEPTION_STATUS_706.getCode(),
                    ResStatusEnum.EXCEPTION_STATUS_706.getMsg());
        }
        // 注册账号
        ChatUser user = new ChatUser();
        user.setUserId(RandomUtil.generateRandomCode(12).toUpperCase(Locale.ROOT));
        user.setNickname(SYS_NAME_PREFIX + RandomUtil.generateRandomCode(12).toLowerCase(Locale.ROOT));
        user.setEmail(email);
        // 生成盐
        String salt = RandomUtil.generateRandomCode(20);
        // 加密
        String slatPass = PwdUtil.encode(userInfo.getPassword(), salt);
        user.setSalt(salt);
        user.setPassword(slatPass);
        int insert = chatUserMapper.insert(user);
        if (insert == 0) {
            throw new AuthorityException(
                    ResStatusEnum.EXCEPTION_STATUS_702.getCode(),
                    ResStatusEnum.EXCEPTION_STATUS_702.getMsg());
        }
        return Result.success(Maps.newHashMap(), 0);
    }
    
    @Override
    public Result<Map<String, String>> getImgVerifyCode(HttpServletResponse response) {
        Map<String, String> result = Maps.newHashMap();
        VerifyCodeUtil verifyCodeUtils = null;
        try {
            verifyCodeUtils = new VerifyCodeUtil();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String vToken = verifyCodeUtils.getVToken();
        result.put("base64Img", verifyCodeUtils.getBase64ImageStr());
        result.put("verToken", vToken);
        redisUtil.set(RedisConst.IMG_CAPTCHA_PREFIX + vToken, verifyCodeUtils.getText(), 60, TimeUnit.SECONDS);
        log.info("MailSendServiceImpl.getVerifyCodeImg当前生成数据为：{}", result);
        return Result.success(result);
    }
}
