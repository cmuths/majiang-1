package com.hejinwei.majiang.api.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
//@Aspect注解表示:申明这是一个切面类
@Aspect  
@Component
public class ServiceAspect {  
	private static final Logger logger = LoggerFactory.getLogger(ServiceAspect.class);
	
    @Around("execution(* com.hejinwei.majiang.api.controller..*.*(..))")  
    public Object process(ProceedingJoinPoint jp) throws java.lang.Throwable {
    	Object rvt = null;
			long startTime = System.currentTimeMillis();
			String methodInfo = jp.getTarget().getClass().getSimpleName() + "."+ jp.getSignature().getName();
			String paramInfo = JSON.toJSONString(jp.getArgs());
			logger.info("调用方法:{},  参数:{}}", methodInfo, paramInfo);
			rvt = jp.proceed();
			long endTime = System.currentTimeMillis();
			String returnInfo = JSON.toJSONString(rvt);
			long time = endTime - startTime;
			logger.info("{调用方法:{},  返回值:{},  耗时:{}毫秒}", methodInfo, returnInfo, time);
			return rvt;
    }
} 