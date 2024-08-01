package cn.sxgan.chat.common.exception;

import cn.sxgan.chat.common.enums.ResStatusEnum;
import cn.sxgan.chat.common.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @Description: 全局异常处理器
 * @Author: sxgan
 * @Date: 24/8/1 18:12
 * @Version: 1.0
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    // 指定出现什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody // 为了返回数据
    public Result<String> error(Exception e) {
        e.printStackTrace();
        log.error("GlobalExceptionHandler Exception e {}", ExceptionUtils.getMessage(e));
        return Result.fail(ResStatusEnum.HTTP_STATUS_500.getMsg());
    }
    
    // 自定义异常
    @ExceptionHandler(AuthorityException.class)
    @ResponseBody
    public Result<String> error(AuthorityException e) {
        log.error(ExceptionUtils.getMessage(e));
        e.printStackTrace();
        log.error("AuthorityException Exception e {}", ExceptionUtils.getMessage(e));
        return Result.fail(e.getMsg());
    }
    
    // 特定异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody // 为了返回数据
    public Result<String> error(ArithmeticException e) {
        e.printStackTrace();
        log.error("ArithmeticException Exception e {}", ExceptionUtils.getMessage(e));
        return Result.fail("执行了ArithmeticException异常处理..");
    }
    
    // 特定异常
    @ExceptionHandler(value = {IOException.class, HttpMessageNotWritableException.class})
    @ResponseBody // 为了返回数据
    public Result<String> error(IOException e) {
        // e.printStackTrace();
        
        log.error("IOException Exception e {}", ExceptionUtils.getMessage(e));
        return Result.fail("执行了IOException异常处理..");
    }
    
    
}
