package cn.sxgan.chat.admin.api.auth;

import cn.sxgan.chat.common.entity.UserInfo;
import cn.sxgan.chat.common.response.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

/**
 * @Description: 认证服务控制层接口
 * @Author: sxgan
 * @Date: 2024-08-02 15:29
 * @Version: 1.0
 **/
@Tag(name = "认证服务", description = "用户权限校验")
public interface IAuthControllerApi {
    
    @Operation(summary = "获取邮箱验证码", description = "请求邮箱验证码",
            parameters = {
                    @Parameter(name = "UserInfo", description = "用户会话对象", content = @Content(mediaType = "application/json", schema = @Schema(contentSchema = UserInfo.class)))
            },
            responses = {
                    @ApiResponse(description = "返回验证码", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Map.class))),
                    @ApiResponse(responseCode = "400", description = "返回400时错误")
            })
    Result<String> sendEmailVerifyCode(UserInfo userInfo);
    
    
    @Operation(summary = "注册", description = "注册接口",
            parameters = {
                    @Parameter(name = "userInfo", description = "用户会话对象", content = @Content(mediaType = "application/json", schema = @Schema(contentSchema = UserInfo.class)))
            },
            responses = {
                    @ApiResponse(description = "返回注册结果", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Map.class))),
                    @ApiResponse(responseCode = "400", description = "返回400时错误")
            })
    Result<Map<String, String>> signup(UserInfo userInfo);
    
    @Operation(summary = "获取图片验证码", description = "请求图片验证码",
            responses = {
                    @ApiResponse(description = "返回验证码", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Map.class))),
                    @ApiResponse(responseCode = "400", description = "返回400时错误")
            })
    Result<Map<String, String>> getImgVerifyCode(HttpServletResponse response);
    
    @Operation(summary = "登录", description = "登录接口",
            parameters = {
                    @Parameter(name = "userInfo", description = "用户会话对象", content = @Content(mediaType = "application/json", schema = @Schema(contentSchema = UserInfo.class)))
            },
            responses = {
                    @ApiResponse(description = "返回登录结果", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                    @ApiResponse(responseCode = "700~800", description = "系统权限校验业务错误")
            })
    Result<Map<String, String>> signin(UserInfo userInfo);
}
