package cn.sxgan.chat.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 联系人关联表实体类
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-08-12
 * @Version: 1.0.0
 **/
@Data
@TableName(value = "user_contact")
@Schema(name = "UserContact", description = "联系人关联表实体类")
public class UserContact {
    /**
     * 用户id
     */
    @TableId
    @Schema(description = "用户id", type = "String")
    private String userId;
    
    /**
     * 联系人id或者群组id
     */
    @Schema(description = "联系人id或者群组id", type = "String")
    private String contactId;
    
    /**
     * 联系人类型0:好友1:群组
     */
    @Schema(description = "联系人类型0:好友1:群组", type = "Integer")
    private Integer contactType;
    
    /**
     * 状态0:非好友 1:好友 2:已删除好友 3:被好友删除 4:已拉黑好友 5:被好友拉黑
     */
    @Schema(description = "状态0:非好友 1:好友 2:已删除好友 3:被好友删除 4:已拉黑好友 5:被好友拉黑", type = "Integer")
    private Integer status;
    
    /**
     * 创建时间
     */
    @Schema(description = "创建时间", type = "Date")
    private Date createTime;
    
    /**
     * 最后更新时间
     */
    @Schema(description = "最后更新时间", type = "Date")
    private Date lastUpdateTime;
    
}