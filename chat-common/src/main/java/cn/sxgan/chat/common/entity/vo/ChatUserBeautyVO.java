package cn.sxgan.chat.common.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 靓号表视图对象
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-08-12
 * @Version: 1.0.0
 **/
@Data
@Schema(name = "ChatUserBeautyVO", description = "靓号表")
public class ChatUserBeautyVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    
    @Schema(description = "靓号自增ID")
    private Integer beautyId;
    
    @Schema(description = "用户邮箱")
    private String email;
    
    @Schema(description = "用户ID")
    private String userId;
    
    @Schema(description = "是否启用(0未启用 1已使用)")
    private Integer status;
    
    @Schema(description = "创建时间")
    private Date createTime;
    
    @Schema(description = "更新时间")
    private Date updateTime;
    
    
}