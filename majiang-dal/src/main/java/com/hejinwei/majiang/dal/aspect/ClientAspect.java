package com.hejinwei.majiang.dal.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

@Aspect  
public class ClientAspect {  
	private static final Logger logger = LoggerFactory.getLogger(ClientAspect.class);
	
    @Around("execution(* com.hejinwei.majiang.dal.soap.client.impl..*.*(..)) || execution(* com.hejinwei.majiang.dal.impl..*.*(..))")  
    public Object process(ProceedingJoinPoint jp) throws java.lang.Throwable {
    	long startTime = System.currentTimeMillis();
    	String methodInfo = jp.getTarget().getClass().getSimpleName() + "." + jp.getSignature().getName();
    	String paramInfo = JSON.toJSONString(jp.getArgs());
    	logger.info("调用方法:{},  参数:{}}", methodInfo, paramInfo);
        Object rvt = jp.proceed();
        long endTime = System.currentTimeMillis();
        String returnInfo = JSON.toJSONString(rvt);
        long time = endTime - startTime;
        logger.info("{调用方法:{},  返回值:{},  耗时:{}毫秒}", methodInfo, returnInfo, time);
        return rvt;
    }  
} 