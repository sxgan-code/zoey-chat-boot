package cn.sxgan.chat.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 群组表实体类
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-08-12
 * @Version: 1.0.0
 **/
@Data
@TableName(value = "chat_group")
@Schema(name = "ChatGroup", description = "群组表实体类")
public class ChatGroup {
    /**
     * 群id
     */
    @TableId
    @Schema(description = "群id", type = "String")
    private String groupId;
    
    /**
     * 群组名
     */
    @Schema(description = "群组名", type = "String")
    private String groupName;
    
    /**
     * 群主id
     */
    @Schema(description = "群主id", type = "String")
    private String groupOwnerId;
    
    /**
     * 群公告
     */
    @Schema(description = "群公告", type = "String")
    private String groupNotice;
    
    /**
     * o:直接加入 1:管理员同意后加入
     */
    @Schema(description = "o:直接加入 1:管理员同意后加入", type = "Integer")
    private Integer joinType;
    
    /**
     * 状态1:正常0:解散
     */
    @Schema(description = "状态1:正常0:解散", type = "Integer")
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