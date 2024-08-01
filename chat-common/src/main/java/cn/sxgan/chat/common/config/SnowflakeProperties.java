package cn.sxgan.chat.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: 生成雪花所需系统属性值
 * @Author: sxgan
 * @Date: 24/8/1 16:44
 * @Version: 1.0
 **/
@Component
@ConfigurationProperties(prefix = "snowflake")
@Data
public class SnowflakeProperties {
    // 数据中心id
    private Long datacenterId;
    // 数据中心id位数
    private Long datacenterBits;
    // 机器id
    private Long workerId;
    // 机器id位数
    private Long workerBits;
    // 序列id所占位数
    private Long sequenceBits;
    // 时间戳起始点（毫秒）
    private Long twepoch;
    // 单次批量生成id的最大数量
    private Integer maxBatchCount;
}