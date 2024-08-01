package cn.sxgan.chat.common.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 请求日志注解，该注解会打印请求入参(注意目前只可在controller层使用)
 * @Author: sxgan
 * @Date: 24/8/1 16:55
 * @Version: 1.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface RequestBeforeLog {
}