package cn.sxgan.chat.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Description: 权限异常处理类
 * @Author: sxgan
 * @Date: 24/8/1 18:13
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor  // 生成有参数构造方法
@NoArgsConstructor   // 生成无参数构造
@EqualsAndHashCode(callSuper = true)
public class AuthorityException extends RuntimeException {
    private Integer code;// 状态码
    private String msg;// 异常信息
}