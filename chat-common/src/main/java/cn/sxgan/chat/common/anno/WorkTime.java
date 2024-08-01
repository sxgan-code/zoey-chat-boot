package cn.sxgan.chat.common.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 标识一个方法，用于计算方法执行时间
 * @Author: sxgan
 * @Date: 24/8/1 16:55
 * @Version: 1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WorkTime {
    String value() default "Method";
}