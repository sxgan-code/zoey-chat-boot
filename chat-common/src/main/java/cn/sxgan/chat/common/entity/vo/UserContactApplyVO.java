package cn.sxgan.chat.common.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Description: 联系人申请表视图对象
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-08-12
 * @Version: 1.0.0
 **/
@Data
@Schema(name = "UserContactApplyVO", description = "联系人申请表")
public class UserContactApplyVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    
    @Schema(description = "自增id")
    private Long applyId;
    
    @Schema(description = "申请人id")
    private String applyUserId;
    
    @Schema(description = "接受人id")
    private String ackUserId;
    
    @Schema(description = "联系人类型0:好友1:群组")
    private Integer contactType;
    
    @Schema(description = "联系人id或者群组id")
    private String contactId;
    
    @Schema(description = "状态0:待处理1:已同意2:已拒绝3:已拉黑")
    private Integer status;
    
    @Schema(description = "申请信息")
    private String applyInfo;
    
    @Schema(description = "最后申请时间")
    private Long lastApplyTime;
    
    
}