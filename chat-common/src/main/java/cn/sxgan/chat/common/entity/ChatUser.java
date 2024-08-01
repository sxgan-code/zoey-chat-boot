package cn.sxgan.chat.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 用户信息表实体类
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-08-01
 * @Version: 1.0.0
 **/
@Data
@TableName(value = "chat_user")
@Schema(name = "ChatUser", description = "用户信息表实体类")
public class ChatUser {
    /**
     * 用户ID
     */
    @TableId
    @Schema(description = "用户ID", type = "String")
    private String userId;
    
    /**
     * 用户邮箱
     */
    @Schema(description = "用户邮箱", type = "String")
    private String email;
    
    /**
     * 用户昵称
     */
    @Schema(description = "用户昵称", type = "String")
    private String nickname;
    
    /**
     * 0:直接加入 1:同意后加为好友
     */
    @Schema(description = "0:直接加入 1:同意后加为好友", type = "Integer")
    private Integer joinType;
    
    /**
     * 用户性别（0男 1女 2未知）
     */
    @Schema(description = "用户性别（0男 1女 2未知）", type = "Integer")
    private Integer sex;
    
    /**
     * 密码
     */
    @Schema(description = "密码", type = "String")
    private String password;
    
    /**
     * 盐加密
     */
    @Schema(description = "盐加密", type = "String")
    private String salt;
    
    /**
     * 个性签名
     */
    @Schema(description = "个性签名", type = "String")
    private String personalSign;
    
    /**
     * 帐号状态（1正常 0停用）
     */
    @Schema(description = "帐号状态（1正常 0停用）", type = "Integer")
    private Integer status;
    
    /**
     * 手机号码
     */
    @Schema(description = "手机号码", type = "String")
    private String phoneNumber;
    
    /**
     * 头像路径
     */
    @Schema(description = "头像路径", type = "String")
    private String avatar;
    
    /**
     * 部门ID
     */
    @Schema(description = "部门ID", type = "Long")
    private Long deptId;
    
    /**
     * 地区
     */
    @Schema(description = "地区", type = "String")
    private String areaName;
    
    /**
     * 地区编号
     */
    @Schema(description = "地区编号", type = "String")
    private String areaCode;
    
    /**
     * 创建者
     */
    @Schema(description = "创建者", type = "String")
    private String createBy;
    
    /**
     * 更新者
     */
    @Schema(description = "更新者", type = "String")
    private String updateBy;
    
    /**
     * 最后登录IP
     */
    @Schema(description = "最后登录IP", type = "String")
    private String loginIp;
    
    /**
     * 最后登录时间
     */
    @Schema(description = "最后登录时间", type = "Date")
    private Date loginDate;
    
    /**
     * 密码最后更新时间
     */
    @Schema(description = "密码最后更新时间", type = "Date")
    private Date pwdUpdateDate;
    
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
    
    /**
     * 备注
     */
    @Schema(description = "备注", type = "String")
    private String remark;
    
    /**
     * 删除标志（0代表启用 1代表注销）
     */
    @Schema(description = "删除标志（0代表启用 1代表注销）", type = "Integer")
    private Integer delFlag;
    
}