package cn.sxgan.chat.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 靓号表实体类
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-08-12
 * @Version: 1.0.0
 **/
@Data
@TableName(value = "chat_user_beauty")
@Schema(name = "ChatUserBeauty", description = "靓号表实体类")
public class ChatUserBeauty {
    /**
     * 靓号自增ID
     */
    @TableId
    @Schema(description = "靓号自增ID", type = "Integer")
    private Integer beautyId;
    
    /**
     * 用户邮箱
     */
    @Schema(description = "用户邮箱", type = "String")
    private String email;
    
    /**
     * 用户ID
     */
    @Schema(description = "用户ID", type = "String")
    private String userId;
    
    /**
     * 是否启用(0未启用 1已使用)
     */
    @Schema(description = "是否启用(0未启用 1已使用)", type = "Integer")
    private Integer status;
    
    /**
     * 创建时间
     */
    @Schema(description = "创建时间", type = "Date")
    private Date createTime;
    
    /**
     * 更新时间
     */
    @Schema(description = "更新时间", type = "Date")
    private Date updateTime;
    
}