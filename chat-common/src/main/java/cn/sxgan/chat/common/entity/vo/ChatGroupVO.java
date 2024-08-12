package cn.sxgan.chat.common.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 群组表视图对象
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-08-12
 * @Version: 1.0.0
 **/
@Data
@Schema(name = "ChatGroupVO", description = "群组表")
public class ChatGroupVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    
    @Schema(description = "群id")
    private String groupId;
    
    @Schema(description = "群组名")
    private String groupName;
    
    @Schema(description = "群主id")
    private String groupOwnerId;
    
    @Schema(description = "群公告")
    private String groupNotice;
    
    @Schema(description = "o:直接加入 1:管理员同意后加入")
    private Integer joinType;
    
    @Schema(description = "状态1:正常0:解散")
    private Integer status;
    
    @Schema(description = "创建时间")
    private Date createTime;
    
    @Schema(description = "更新时间")
    private Date updateTime;
    
    
}