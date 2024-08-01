package cn.sxgan.chat.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description: 全局属性
 * @Author: sxgan
 * @Date: 24/8/1 18:15
 * @Version: 1.0
 **/
@Data
@Component
public class ZoeyConfig {
    @Value("${token.admin.secretKey}")
    String secretKey;
}