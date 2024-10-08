package cn.sxgan.chat.common.aspect;

import cn.sxgan.chat.common.anno.WorkTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 执行时间切面
 * @Author: sxgan
 * @Date: 2024-05-19 10:51
 * @Version: 1.0
 **/
@Slf4j
@Aspect
@Order(-1)
@Component
public class WorkTimeAspect {
    
    @Around(value = "@annotation(workTime)", argNames = "joinPoint,workTime")
    public Object jobRun(ProceedingJoinPoint joinPoint, WorkTime workTime) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        log.info("开始执行----->[{}]", workTime.value());
        stopWatch.start(workTime.value());
        Object result = joinPoint.proceed();
        stopWatch.stop();
        log.info("执行结束----->[{}],总耗时{}秒", workTime.value(), stopWatch.getTotalTime(TimeUnit.SECONDS));
        return result;
    }
}
