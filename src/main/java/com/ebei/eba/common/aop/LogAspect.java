package com.ebei.eba.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Description:
 * @Auther: yangsm
 * @Date: 2018/8/13
 */
@Aspect
@Component
public class LogAspect {
    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**定义切点*/
    @Pointcut("execution(public * com.ebei.eba.controller.*.*(..))")
    public void doLog(){} //切点载体

    @Around("doLog()")
    public Object doAroundLog(ProceedingJoinPoint thisJoinPoint){
        Object r = null;
        try {
            ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = sra.getRequest();

            String userId = request.getHeader("userId");
            String url = request.getRequestURL().toString();

            long startTime = new Date().getTime();
             r = thisJoinPoint.proceed ();//被代理对象
            long subTime = new Date().getTime() - startTime; //截取时间段
            logger.info(url+">"+thisJoinPoint.getSignature().getName()+ ">" + (subTime) +"（豪秒） userId：" +userId);
        } catch (Throwable e) {
            logger.error("异常",e);
        }
        return r;
    }

}
