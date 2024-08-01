package cn.sxgan.chat.admin.api;

import cn.sxgan.chat.common.response.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: 测试API接口
 * @Author: sxgan
 * @Date: 2024-08-01 13:30
 * @Version: 1.0
 **/
@Tag(name = "测试接口", description = "测试系统运行及配置")
public interface ITestControllerApi {
    @Operation(summary = "测试接口",
            description = "测试基本返回数据接口",
            parameters = {
                    @Parameter(name = "var", description = "传入参数1", example = "aaa")
            },
            responses = {
                    @ApiResponse(description = "返回一个测试字符串",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                    @ApiResponse(responseCode = "400", description = "返回400时错误")
            })
    Result<String> hello(@RequestParam String var);
}
