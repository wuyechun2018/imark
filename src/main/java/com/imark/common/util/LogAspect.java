package com.imark.common.util;

import com.imark.system.model.SysMarkLogs;
import com.imark.system.service.h2.MarkLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
* 类名: LogAspect
* 包名: com.imark.common.util
* 描述: 系统日志，面向切面
* 创建人: ycwu3
* 创建时间: 2017/9/19 16:14
**/

@Aspect
@Component
public class LogAspect {


    @Autowired
    private MarkLogService markLogService;

    @Pointcut("@annotation(com.imark.common.util.SystemLog)")
    public  void logAspect() {
    }


    @AfterThrowing(pointcut = "logAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint point, Throwable e) {

    }


   /** @Around("logAspect()")
    public void doController(ProceedingJoinPoint joinPoint) throws Throwable {

        joinPoint.proceed();
    }**/



    @After("logAspect()")
    public void afterController(JoinPoint joinPoint) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;
        HttpServletRequest request = sra.getRequest();

        //记录登录日志
        SysMarkLogs log=new SysMarkLogs();
        //记录访问者的IP
        log.setBizParam(IUtil.getIpAddr(request));
        //记录访问时间
         log.setOpDate(IUtil.getCurDate());
         markLogService.save(log);
    }

}
