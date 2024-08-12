package cn.sxgan.chat.common.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 联系人关联表视图对象
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-08-12
 * @Version: 1.0.0
 **/
@Data
@Schema(name = "UserContactVO", description = "联系人关联表")
public class UserContactVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Schema(description = "用户id")
    private String userId;
    
    @Schema(description = "联系人id或者群组id")
    private String contactId;
    
    @Schema(description = "联系人类型0:好友1:群组")
    private Integer contactType;
    
    @Schema(description = "状态0:非好友 1:好友 2:已删除好友 3:被好友删除 4:已拉黑好友 5:被好友拉黑")
    private Integer status;
    
    @Schema(description = "创建时间")
    private Date createTime;
    
    @Schema(description = "最后更新时间")
    private Date lastUpdateTime;
    
    
}