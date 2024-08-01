package cn.sxgan.chat.common.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 用户信息表视图对象
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-08-01
 * @Version: 1.0.0
 **/
@Data
@Schema(name = "ChatUserVO", description = "用户信息表")
public class ChatUserVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Schema(description = "用户ID")
    private String userId;
    
    @Schema(description = "用户邮箱")
    private String email;
    
    @Schema(description = "用户昵称")
    private String nickname;
    
    @Schema(description = "0:直接加入 1:同意后加为好友")
    private Integer joinType;
    
    @Schema(description = "用户性别（0男 1女 2未知）")
    private Integer sex;
    
    @Schema(description = "密码")
    private String password;
    
    @Schema(description = "盐加密")
    private String salt;
    
    @Schema(description = "个性签名")
    private String personalSign;
    
    @Schema(description = "帐号状态（1正常 0停用）")
    private Integer status;
    
    @Schema(description = "手机号码")
    private String phoneNumber;
    
    @Schema(description = "头像路径")
    private String avatar;
    
    @Schema(description = "部门ID")
    private Long deptId;
    
    @Schema(description = "地区")
    private String areaName;
    
    @Schema(description = "地区编号")
    private String areaCode;
    
    @Schema(description = "创建者")
    private String createBy;
    
    @Schema(description = "更新者")
    private String updateBy;
    
    @Schema(description = "最后登录IP")
    private String loginIp;
    
    @Schema(description = "最后登录时间")
    private Date loginDate;
    
    @Schema(description = "密码最后更新时间")
    private Date pwdUpdateDate;
    
    @Schema(description = "创建时间")
    private Date createTime;
    
    @Schema(description = "更新时间")
    private Date updateTime;
    
    @Schema(description = "备注")
    private String remark;
    
    @Schema(description = "删除标志（0代表启用 1代表注销）")
    private Integer delFlag;
    
    
}