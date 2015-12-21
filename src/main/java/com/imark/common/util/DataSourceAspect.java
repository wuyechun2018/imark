package com.imark.common.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.imark.uaac.controller.AddressController;

@Component
@Aspect
public class DataSourceAspect {

	private static final Logger log = LoggerFactory.getLogger(AddressController.class);

	@Pointcut("execution(* com.imark.*.service.h2..*(..))")
	public void aspect() {
	}

	/*
	 * 配置前置通知,使用在方法aspect()上注册的切入点 同时接受JoinPoint切入点对象,可以没有该参数
	 */
	@Before("aspect()")
	public void before(JoinPoint joinPoint) {
		//joinPoint.getClass().getPackage().getName();
		//设置使用H2数据源
		DBContextHolder.setDBType(Constant.DATA_SOURCE_THREE);
	}

	
	// 配置后置通知,使用在方法aspect()上注册的切入点
	@After("aspect()")
	public void after(JoinPoint joinPoint) {
		//设置使用oracle数据源
		DBContextHolder.setDBType(Constant.DATA_SOURCE_ONE);
	}

	/***
	// 配置环绕通知,使用在方法aspect()上注册的切入点
	@Around("aspect()")
	public void around(JoinPoint joinPoint) {
		long start = System.currentTimeMillis();
		try {
			((ProceedingJoinPoint) joinPoint).proceed();
			long end = System.currentTimeMillis();
			if (log.isInfoEnabled()) {
				log.info("around " + joinPoint + "\tUse time : "+ (end - start) + " ms!");
			}
		} catch (Throwable e) {
			long end = System.currentTimeMillis();
			if (log.isInfoEnabled()) {
				log.info("around " + joinPoint + "\tUse time : "+ (end - start) + " ms with exception : "+ e.getMessage());
			}
		}
	}
	//方法执行的前后调用  
   	@Around("execution (* com.zywang.services.impl.*.*(..))")  
    public Object around(ProceedingJoinPoint point) throws Throwable{  
        System.out.println("begin around");  
        Object object = point.proceed();  
        System.out.println("end around");  
        return object;  
    }  


	// 配置后置返回通知,使用在方法aspect()上注册的切入点
	@AfterReturning("aspect()")
	public void afterReturn(JoinPoint joinPoint) {
		if (log.isInfoEnabled()) {
			log.info("afterReturn " + joinPoint);
		}
	}

	// 配置抛出异常后通知,使用在方法aspect()上注册的切入点
	@AfterThrowing(pointcut = "aspect()", throwing = "ex")
	public void afterThrow(JoinPoint joinPoint, Exception ex) {
		if (log.isInfoEnabled()) {
			log.info("afterThrow " + joinPoint + "\t" + ex.getMessage());
		}
	}
	***/

}
