package cn.sxgan.chat.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 联系人申请表实体类
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-08-12
 * @Version: 1.0.0
 **/
@Data
@TableName(value = "user_contact_apply")
@Schema(name = "UserContactApply", description = "联系人申请表实体类")
public class UserContactApply {
    /**
     * 自增id
     */
    @TableId
    @Schema(description = "自增id", type = "Long")
    private Long applyId;
    
    /**
     * 申请人id
     */
    @Schema(description = "申请人id", type = "String")
    private String applyUserId;
    
    /**
     * 接受人id
     */
    @Schema(description = "接受人id", type = "String")
    private String ackUserId;
    
    /**
     * 联系人类型0:好友1:群组
     */
    @Schema(description = "联系人类型0:好友1:群组", type = "Integer")
    private Integer contactType;
    
    /**
     * 联系人id或者群组id
     */
    @Schema(description = "联系人id或者群组id", type = "String")
    private String contactId;
    
    /**
     * 状态0:待处理1:已同意2:已拒绝3:已拉黑
     */
    @Schema(description = "状态0:待处理1:已同意2:已拒绝3:已拉黑", type = "Integer")
    private Integer status;
    
    /**
     * 申请信息
     */
    @Schema(description = "申请信息", type = "String")
    private String applyInfo;
    
    /**
     * 最后申请时间
     */
    @Schema(description = "最后申请时间", type = "Long")
    private Long lastApplyTime;
    
}